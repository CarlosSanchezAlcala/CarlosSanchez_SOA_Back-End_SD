package com.legal_guardian_soa_canete_2023.repository;

import com.legal_guardian_soa_canete_2023.model.family;
import com.legal_guardian_soa_canete_2023.model.familyDetails;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface familyRepository extends ReactiveCrudRepository<family, Integer> {
}