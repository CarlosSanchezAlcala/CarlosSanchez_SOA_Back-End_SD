package com.legal_guardian_soa_canete_2023.service.impl;

import com.legal_guardian_soa_canete_2023.domain.dto.adolescentDto.AdolescentRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.adolescentDto.AdolescentResponseDto;
import com.legal_guardian_soa_canete_2023.domain.mapper.AdolescentMapper;
import com.legal_guardian_soa_canete_2023.domain.model.Adolescent;
import com.legal_guardian_soa_canete_2023.exception.ResourceNotFoundException;
import com.legal_guardian_soa_canete_2023.repository.AdolescentRepository;
import com.legal_guardian_soa_canete_2023.service.AdolescentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Comparator;
import static com.legal_guardian_soa_canete_2023.domain.mapper.AdolescentMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdolescentImpl implements AdolescentService {

    final AdolescentRepository adolescentRepository;

    @Override
    public Mono<AdolescentResponseDto> findById(Integer id) {
        return this.adolescentRepository.findById(id)
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Flux<AdolescentResponseDto> findAll() {
        return this.adolescentRepository.findAll()
                .sort(Comparator.comparing(Adolescent::getId).reversed())
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Flux<AdolescentResponseDto> findAllActive() {
        return this.adolescentRepository.findAll()
                .sort(Comparator.comparing(Adolescent::getId).reversed())
                .filter(active -> active.getActive().equals("A"))
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Flux<AdolescentResponseDto> findAllInactive() {
        return this.adolescentRepository.findAll()
                .sort(Comparator.comparing(Adolescent::getId).reversed())
                .filter(active -> active.getActive().equals("I"))
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Mono<AdolescentResponseDto> saveNewAdolescent(AdolescentRequestDto request) {
        return this.adolescentRepository.save(toModel(request))
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Mono<AdolescentResponseDto> updateAdolescent(AdolescentRequestDto request, Integer id) {
        return this.adolescentRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El identificador:" + id +"no fue encontrado")))
                .flatMap(dataAdolescent -> this.adolescentRepository.save(toModel(request, dataAdolescent.getId())))
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Mono<AdolescentResponseDto> deleteLogicalAdolescent(Integer id) {
        return this.adolescentRepository.findById(id)
                .map((delete) -> {
                    delete.setActive("I");
                    return delete;
                })
                .flatMap(adolescentRepository::save)
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Mono<AdolescentResponseDto> reactiveLogicalAdolescent(Integer id) {
        return this.adolescentRepository.findById(id)
                .map((delete) -> {
                    delete.setActive("A");
                    return delete;
                })
                .flatMap(adolescentRepository::save)
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Mono<Void> deleteAdolescent(Integer id) {
        return this.adolescentRepository.deleteById(id);
    }
}
