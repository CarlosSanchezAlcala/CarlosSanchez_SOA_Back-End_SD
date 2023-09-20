package com.legal_guardian_soa_canete_2023.web;

import com.legal_guardian_soa_canete_2023.domain.dto.TransactionalDataDto;
import com.legal_guardian_soa_canete_2023.domain.model.Family;
import com.legal_guardian_soa_canete_2023.repository.AdolescentRepository;
import com.legal_guardian_soa_canete_2023.repository.FamilyRepository;
import com.legal_guardian_soa_canete_2023.repository.LegalGuardianRepository;
import com.legal_guardian_soa_canete_2023.service.FamilyService;
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
    final FamilyService familyService;

    @GetMapping("/infoFamily")
    public String informationAdolescent() {
        return "Información completa sobre las familia formadas";
    }

    @GetMapping("/{idFamilyData}")
    public Mono<TransactionalDataDto> getDataTransactionalFamily(@PathVariable Integer idFamilyData) {
        return familyService.findById(idFamilyData);
    }

    @PostMapping
    public Mono<Family> saveNewFamily(@RequestBody Family family) {
        return familyRepository.save(family);
    }

    @GetMapping("/list/data/family")
    public Flux<Family> getDataInfoFamily() {
        return familyRepository.findAll()
                .sort(Comparator.comparing(Family::getId));
    }
}
