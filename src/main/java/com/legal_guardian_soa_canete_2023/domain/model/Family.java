package com.legal_guardian_soa_canete_2023.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "family_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Family {
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

    public Family(Integer idLegalGuardian, Integer idAdolescent, String active, String description) {
        this.idLegalGuardian = idLegalGuardian;
        this.idAdolescent = idAdolescent;
        this.active = active;
        this.description = description;
    }

}
