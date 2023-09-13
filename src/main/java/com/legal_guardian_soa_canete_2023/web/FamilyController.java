package com.legal_guardian_soa_canete_2023.web;

import com.legal_guardian_soa_canete_2023.model.family;
import com.legal_guardian_soa_canete_2023.model.familyDetails;
import com.legal_guardian_soa_canete_2023.repository.FamilyRepository;
import com.legal_guardian_soa_canete_2023.repository.LegalGuardianRepository;
import com.legal_guardian_soa_canete_2023.repository.AdolescentRepository;
import com.legal_guardian_soa_canete_2023.repository.FamilyDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/familyData")
@RequiredArgsConstructor
public class FamilyController {

    final FamilyRepository familyRepository;
    final LegalGuardianRepository legalGuardianRepository;
    final AdolescentRepository adolescentRepository;
    final FamilyDetailsRepository familyDetailsRepository;

    @GetMapping("/infoFamily")
    public String informationAdolescent() {
        return "Información completa sobre las familia formadas";
    }

    @PostMapping
    public Mono<family> saveNewFamily(@RequestBody family family) {
        return familyRepository.save(family);
    }

    @GetMapping("/list/data/family")
    public Flux<family> getDataInfoFamily() {
        return familyRepository.findAll()
                .sort(Comparator.comparing(family::getId));
    }

    @GetMapping("/list/dataDetails/familyDetails")
    public Flux<familyDetails> getDataDetailsFamily() {
        return familyDetailsRepository.findAll()
                .sort(Comparator.comparing(familyDetails::getId));
    }
}
