package com.legal_guardian_soa_canete_2023.domain.dto;

import com.legal_guardian_soa_canete_2023.domain.dto.adolescentDto.AdolescentResponseDto;
import com.legal_guardian_soa_canete_2023.domain.dto.legalGuardianDto.LegalGuardianResponseDto;
import com.legal_guardian_soa_canete_2023.domain.model.Family;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionalDataDto {

    private LegalGuardianResponseDto legalGuardianResponseDto;
    private AdolescentResponseDto adolescentResponseDto;
    private Family family;

}
