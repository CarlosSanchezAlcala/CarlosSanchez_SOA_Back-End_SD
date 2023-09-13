package com.legal_guardian_soa_canete_2023.controller;

import com.legal_guardian_soa_canete_2023.model.family;
import com.legal_guardian_soa_canete_2023.model.familyDetails;
import com.legal_guardian_soa_canete_2023.repository.familyRepository;
import com.legal_guardian_soa_canete_2023.repository.legalGuardianRepository;
import com.legal_guardian_soa_canete_2023.repository.adolescentRepository;
import com.legal_guardian_soa_canete_2023.repository.familyDetailsRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/familyData")
public class familyController {
    final familyRepository familyRepository;
    final legalGuardianRepository legalGuardianRepository;
    final adolescentRepository adolescentRepository;

    final familyDetailsRepository familyDetailsRepository;

    public familyController(familyRepository familyRepository,
                            legalGuardianRepository legalGuardianRepository,
                            adolescentRepository adolescentRepository,
                            familyDetailsRepository familyDetailsRepository) {
        this.familyRepository = familyRepository;
        this.legalGuardianRepository = legalGuardianRepository;
        this.adolescentRepository = adolescentRepository;
        this.familyDetailsRepository = familyDetailsRepository;
    }

    @GetMapping("/infoFamily")
    public String informationAdolescent() {
        return "Información completa sobre las familia formadas";
    }

    @PostMapping
    public  Mono<family> saveNewFamily(@RequestBody family family) {
        return familyRepository.save(family);
    }

    @GetMapping("/list/data/family")
    public Flux<family> getDataInfoFamily () {
        return familyRepository.findAll()
                .sort(Comparator.comparing(family::getId));
    }

    @GetMapping("/list/dataDetails/familyDetails")
    public Flux<familyDetails> getDataDetailsFamily() {
        return familyDetailsRepository.findAll()
                .sort(Comparator.comparing(familyDetails::getId));
    }
}
