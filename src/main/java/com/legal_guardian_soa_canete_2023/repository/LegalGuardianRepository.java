package com.legal_guardian_soa_canete_2023.repository;

import com.legal_guardian_soa_canete_2023.domain.model.LegalGuardian;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LegalGuardianRepository extends ReactiveCrudRepository<LegalGuardian, Integer> {
}
