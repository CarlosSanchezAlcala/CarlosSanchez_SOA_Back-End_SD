package com.legal_guardian_soa_canete_2023.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("family_data")
@Data
public class family {
    @Id
    private Integer id;
    @Column("idLegalGuardian")
    private Integer idLegalGuardian;
    @Column("idAdolescent")
    private Integer idAdolescent;
    @Column
    private String active;
}
