package com.legal_guardian_soa_canete_2023.domain.mapper;

import com.legal_guardian_soa_canete_2023.domain.dto.adolescentDto.AdolescentRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.adolescentDto.AdolescentResponseDto;
import com.legal_guardian_soa_canete_2023.domain.model.Adolescent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdolescentMapper {

    public static Adolescent toModel(AdolescentRequestDto dto) {
        return new Adolescent(
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

    public static Adolescent toModel(AdolescentRequestDto dto, Integer id) {
        return new Adolescent(
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

    public static AdolescentResponseDto toDto(Adolescent model) {
        return new AdolescentResponseDto(
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
