package com.legal_guardian_soa_canete_2023.service;

import com.legal_guardian_soa_canete_2023.domain.dto.adolescentDto.AdolescentRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.adolescentDto.AdolescentResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface AdolescentService {

    Mono<AdolescentResponseDto> findById(Integer id);
    Flux<AdolescentResponseDto> findAll();
    Flux<AdolescentResponseDto> findAllActive();
    Flux<AdolescentResponseDto> findAllInactive();
    Mono<AdolescentResponseDto> saveNewAdolescent(AdolescentRequestDto request);
    Mono<AdolescentResponseDto> updateAdolescent(AdolescentRequestDto request, Integer id);
    Mono<AdolescentResponseDto> deleteLogicalAdolescent(Integer id);
    Mono<AdolescentResponseDto> reactiveLogicalAdolescent(Integer id);
    Mono<Void> deleteAdolescent(Integer id);

}
