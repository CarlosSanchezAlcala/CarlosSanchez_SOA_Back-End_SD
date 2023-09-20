package com.legal_guardian_soa_canete_2023.service;

import com.legal_guardian_soa_canete_2023.domain.dto.familyDto.FamilyRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.familyDto.FamilyResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface FamilyService {
    Mono<FamilyResponseDto> findById(Integer id);
    Flux<FamilyResponseDto> findAll();
    Mono<FamilyResponseDto> saveNewFamily(FamilyRequestDto request);
}
