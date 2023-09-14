package com.legal_guardian_soa_canete_2023.service.impl;

import com.legal_guardian_soa_canete_2023.domain.dto.LegalGuardianRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.LegalGuardianResponseDto;
import com.legal_guardian_soa_canete_2023.domain.mapper.LegalGuardianMapper;
import com.legal_guardian_soa_canete_2023.domain.model.LegalGuardian;
import com.legal_guardian_soa_canete_2023.exception.ResourceNotFoundException;
import com.legal_guardian_soa_canete_2023.repository.LegalGuardianRepository;
import com.legal_guardian_soa_canete_2023.service.LegalGuardianService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Comparator;
import static com.legal_guardian_soa_canete_2023.domain.mapper.LegalGuardianMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class LegalGuardianImpl implements LegalGuardianService {

    final LegalGuardianRepository legalGuardianRepository;

    @Override
    public Mono<LegalGuardianResponseDto> findById(Integer id) {
        return this.legalGuardianRepository.findById(id)
                .map(LegalGuardianMapper::toDto);
    }

    @Override
    public Flux<LegalGuardianResponseDto> findAll() {
        return this.legalGuardianRepository.findAll()
                .sort(Comparator.comparing(LegalGuardian::getId))
                .map(LegalGuardianMapper::toDto);
    }

    @Override
    public Mono<LegalGuardianResponseDto> saveNewLegalGuardian(LegalGuardianRequestDto request) {
        return this.legalGuardianRepository.save(toModel(request))
                .map(LegalGuardianMapper::toDto);
    }

    @Override
    public Mono<LegalGuardianResponseDto> updateLegalGuardian(LegalGuardianRequestDto request, Integer id) {
        return this.legalGuardianRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El identificador:" + id +"no fue encontrado")))
                .flatMap(dataLegal -> this.legalGuardianRepository.save(toModel(request, dataLegal.getId())))
                .map(LegalGuardianMapper::toDto);
    }

    @Override
    public Mono<LegalGuardianResponseDto> deleteLogicalLegalGuardian(Integer id) {
        return this.legalGuardianRepository.findById(id)
                .map((delete) -> {
                    delete.setActive("I");
                    return delete;
                })
                .flatMap(legalGuardianRepository::save)
                .map(LegalGuardianMapper::toDto);
    }

    @Override
    public Mono<LegalGuardianResponseDto> reactiveLogicalLegalGuardian(Integer id) {
        return this.legalGuardianRepository.findById(id)
                .map((reactive) -> {
                    reactive.setActive("A");
                    return reactive;
                })
                .flatMap(legalGuardianRepository::save)
                .map(LegalGuardianMapper::toDto);
    }

    @Override
    public Mono<Void> deleteLegalGuardian(Integer id) {
        return null;
    }

    @Override
    public Flux<LegalGuardianResponseDto> findAllActive() {
        return null;
    }

    @Override
    public Flux<LegalGuardianResponseDto> findAllInactive() {
        return null;
    }
}
