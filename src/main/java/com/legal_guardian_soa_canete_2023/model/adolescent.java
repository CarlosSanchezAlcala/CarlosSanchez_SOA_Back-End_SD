package com.legal_guardian_soa_canete_2023.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class adolescent {
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
}
