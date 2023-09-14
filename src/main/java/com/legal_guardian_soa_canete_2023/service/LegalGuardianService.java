package com.legal_guardian_soa_canete_2023.service;

import com.legal_guardian_soa_canete_2023.domain.dto.LegalGuardianRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.LegalGuardianResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface LegalGuardianService {

    Mono<LegalGuardianResponseDto> findById(Integer id);
    Flux<LegalGuardianResponseDto> findAll();
    Flux<LegalGuardianResponseDto> findAllActive();
    Flux<LegalGuardianResponseDto> findAllInactive();
    Mono<LegalGuardianResponseDto> saveNewLegalGuardian(LegalGuardianRequestDto request);
    Mono<LegalGuardianResponseDto> updateLegalGuardian(LegalGuardianRequestDto request, Integer id);
    Mono<LegalGuardianResponseDto> deleteLogicalLegalGuardian(Integer id);
    Mono<LegalGuardianResponseDto> reactiveLogicalLegalGuardian(Integer id);
    Mono<Void> deleteLegalGuardian(Integer id);

}
