package com.legal_guardian_soa_canete_2023.domain.mapper;

import com.legal_guardian_soa_canete_2023.domain.dto.LegalGuardianRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.LegalGuardianResponseDto;
import com.legal_guardian_soa_canete_2023.domain.model.LegalGuardian;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LegalGuardianMapper {

    public static LegalGuardian toModel(LegalGuardianRequestDto dto) {
        return new LegalGuardian(
                dto.getName(),
                dto.getFather_last_name(),
                dto.getMother_last_name(),
                dto.getDocumentType(),
                dto.getDocumentNumber(),
                dto.getAddress(),
                dto.getCell_phone(),
                dto.getEmail(),
                dto.getActive()
        );
    }

    public static LegalGuardian toModel(LegalGuardianRequestDto dto, Integer id) {
        return new LegalGuardian(
                id,
                dto.getName(),
                dto.getFather_last_name(),
                dto.getMother_last_name(),
                dto.getDocumentType(),
                dto.getDocumentNumber(),
                dto.getAddress(),
                dto.getCell_phone(),
                dto.getEmail(),
                dto.getActive()
        );
    }

    public static LegalGuardianResponseDto toDto(LegalGuardian model) {
        return new LegalGuardianResponseDto(
                model.getId(),
                model.getName(),
                model.getFather_last_name(),
                model.getMother_last_name(),
                model.getDocumentType(),
                model.getDocumentNumber(),
                model.getAddress(),
                model.getCell_phone(),
                model.getEmail(),
                model.getActive()
        );
    }
}
