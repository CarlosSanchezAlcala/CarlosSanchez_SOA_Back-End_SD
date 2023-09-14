package com.legal_guardian_soa_canete_2023.repository;

import com.legal_guardian_soa_canete_2023.domain.model.FamilyDetails;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FamilyDetailsRepository extends ReactiveCrudRepository<FamilyDetails, Integer> {
}