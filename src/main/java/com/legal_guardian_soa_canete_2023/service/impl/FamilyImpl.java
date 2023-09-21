package com.legal_guardian_soa_canete_2023.service.impl;

import com.legal_guardian_soa_canete_2023.domain.dto.TransactionalDataDto;
import com.legal_guardian_soa_canete_2023.domain.dto.adolescentDto.AdolescentResponseDto;
import com.legal_guardian_soa_canete_2023.domain.dto.familyDto.FamilyRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.familyDto.FamilyResponseDto;
import com.legal_guardian_soa_canete_2023.domain.dto.legalGuardianDto.LegalGuardianResponseDto;
import com.legal_guardian_soa_canete_2023.domain.mapper.FamilyMapper;
import com.legal_guardian_soa_canete_2023.domain.model.Family;
import com.legal_guardian_soa_canete_2023.repository.FamilyRepository;
import com.legal_guardian_soa_canete_2023.service.FamilyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.legal_guardian_soa_canete_2023.domain.mapper.FamilyMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class FamilyImpl implements FamilyService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    final FamilyRepository familyRepository;

    @Override
    public Mono<TransactionalDataDto> findById(Integer id) {
        Mono<Family> family = familyRepository.findById(id);
        return family.flatMap(dataFamily -> {
            Mono<LegalGuardianResponseDto> legalGuardianResponseDto = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/api/legalGuardian/" + dataFamily.getIdLegalGuardian())
                    .retrieve()
                    .bodyToMono(LegalGuardianResponseDto.class);
            Mono<AdolescentResponseDto> adolescentResponseDto = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/api/adolescentData/" + dataFamily.getIdAdolescent())
                    .retrieve()
                    .bodyToMono(AdolescentResponseDto.class);
            return legalGuardianResponseDto.zipWith(adolescentResponseDto).map(dataGeneral -> {
                LegalGuardianResponseDto legalGuardianResponseDtoData = dataGeneral.getT1();
                AdolescentResponseDto adolescentResponseDtoData = dataGeneral.getT2();
                TransactionalDataDto transactionalDataDto = new TransactionalDataDto();
                transactionalDataDto.setFamily(dataFamily);
                transactionalDataDto.setAdolescentResponseDto(adolescentResponseDtoData);
                transactionalDataDto.setLegalGuardianResponseDto(legalGuardianResponseDtoData);
                return transactionalDataDto;
            });
        });
    }

    @Override
    public Flux<TransactionalDataDto> findAll() {
        Flux<Family> family = familyRepository.findAll();
        return family.flatMap(datasFamily -> {
            Mono<LegalGuardianResponseDto> legalGuardianResponseDto = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/api/legalGuardian/" + datasFamily.getIdLegalGuardian())
                    .retrieve()
                    .bodyToMono(LegalGuardianResponseDto.class);
            Mono<AdolescentResponseDto> adolescentResponseDto = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/api/adolescentData/" + datasFamily.getIdAdolescent())
                    .retrieve()
                    .bodyToMono(AdolescentResponseDto.class);
            return legalGuardianResponseDto.zipWith(adolescentResponseDto).map(dataGeneral -> {
                LegalGuardianResponseDto legalGuardianResponseDtoData = dataGeneral.getT1();
                AdolescentResponseDto adolescentResponseDtoData = dataGeneral.getT2();
                TransactionalDataDto transactionalDataDto = new TransactionalDataDto();
                transactionalDataDto.setFamily(datasFamily);
                transactionalDataDto.setAdolescentResponseDto(adolescentResponseDtoData);
                transactionalDataDto.setLegalGuardianResponseDto(legalGuardianResponseDtoData);
                return transactionalDataDto;
            });
        });
    }

    @Override
    public Mono<FamilyResponseDto> saveNewFamily(FamilyRequestDto request) {
        return this.familyRepository.save(toModel(request))
                .map(FamilyMapper::toDto);
    }
}
