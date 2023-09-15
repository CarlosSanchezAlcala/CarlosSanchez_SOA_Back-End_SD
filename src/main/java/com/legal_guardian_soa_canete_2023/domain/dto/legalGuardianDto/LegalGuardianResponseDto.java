package com.legal_guardian_soa_canete_2023.domain.dto.legalGuardianDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class LegalGuardianResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8222253670338491507L;

    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private String father_last_name;
    @Column
    private String mother_last_name;
    @Column
    private String documentType;
    @Column
    private String documentNumber;
    @Column
    private String address;
    @Column
    private String cell_phone;
    @Column
    private String email;
    @Column
    private String active;

}
