package com.legal_guardian_soa_canete_2023.domain.mapper;

import com.legal_guardian_soa_canete_2023.domain.dto.familyDto.FamilyRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.familyDto.FamilyResponseDto;
import com.legal_guardian_soa_canete_2023.domain.model.Family;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FamilyMapper {

    public static Family toModel(FamilyRequestDto dto) {
        return new Family(
                dto.getIdLegalGuardian(),
                dto.getIdAdolescent(),
                dto.getActive(),
                dto.getDescription()
        );
    }

    public static Family toModel(FamilyRequestDto dto, Integer id) {
        return new Family(
                id,
                dto.getIdLegalGuardian(),
                dto.getIdAdolescent(),
                dto.getActive(),
                dto.getDescription()
        );
    }

    public static FamilyResponseDto toDto(Family model) {
        return new FamilyResponseDto(
                model.getId(),
                model.getIdLegalGuardian(),
                model.getIdAdolescent(),
                model.getActive(),
                model.getDescription()
        );
    }

}
