package com.legal_guardian_soa_canete_2023.service.impl;

import com.legal_guardian_soa_canete_2023.domain.dto.familyDto.FamilyRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.familyDto.FamilyResponseDto;
import com.legal_guardian_soa_canete_2023.repository.FamilyRepository;
import com.legal_guardian_soa_canete_2023.service.FamilyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class FamilyImpl implements FamilyService {

    final FamilyRepository familyRepository;

    @Override
    public Mono<FamilyResponseDto> findById(Integer id) {
        return null;
    }

    @Override
    public Flux<FamilyResponseDto> findAll() {
        return null;
    }

    @Override
    public Mono<FamilyResponseDto> saveNewFamily(FamilyRequestDto request) {
        return null;
    }
}
