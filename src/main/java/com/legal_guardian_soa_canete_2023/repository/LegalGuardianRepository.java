package com.legal_guardian_soa_canete_2023.repository;

import com.legal_guardian_soa_canete_2023.model.legalGuardian;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LegalGuardianRepository extends ReactiveCrudRepository<legalGuardian, Integer> {
}
