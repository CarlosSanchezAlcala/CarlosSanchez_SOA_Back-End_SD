package com.legal_guardian_soa_canete_2023.domain.dto.familyDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class FamilyResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8222253670338491507L;

    @Id
    private Integer id;
    @Column("idLegalGuardian")
    private Integer idLegalGuardian;
    @Column("idAdolescent")
    private Integer idAdolescent;
    @Column
    private String active;
    @Column
    private String description;
}
