package com.legal_guardian_soa_canete_2023.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("family_detalle_data")
@Data
public class familyDetails {

    @Id
    private Integer id;
    @Column("idFamilyData")
    private Integer idFamilyData;
    @Column("dateCreation")
    private Instant dateCreationData;
    @Column
    private String active;

    public familyDetails(Integer idFamilyData, Instant dateCreationData, String active) {
        this.idFamilyData = idFamilyData;
        this.dateCreationData = dateCreationData;
        this.active = active;
    }

}
