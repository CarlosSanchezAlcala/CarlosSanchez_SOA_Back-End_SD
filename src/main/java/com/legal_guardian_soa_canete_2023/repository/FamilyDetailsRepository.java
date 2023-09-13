package com.legal_guardian_soa_canete_2023.repository;

import com.legal_guardian_soa_canete_2023.model.familyDetails;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FamilyDetailsRepository extends ReactiveCrudRepository<familyDetails, Integer> {
}