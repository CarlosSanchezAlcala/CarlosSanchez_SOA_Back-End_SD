package com.legal_guardian_soa_canete_2023.web;

import com.legal_guardian_soa_canete_2023.domain.model.LegalGuardian;
import com.legal_guardian_soa_canete_2023.repository.LegalGuardianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/legalGuardian")
@RequiredArgsConstructor
public class LegalGuardianController {

    final
    LegalGuardianRepository legalGuardianRepository;

    @GetMapping("/list")
    public Flux<LegalGuardian> getLegalGuardian() {
        return legalGuardianRepository.findAll()
                .sort(Comparator.comparing(LegalGuardian::getId));
    }

    @GetMapping("/list/active")
    public Flux<LegalGuardian> getLegalGuardianActive() {
        return legalGuardianRepository.findAll()
                .sort(Comparator.comparing(LegalGuardian::getId))
                .filter(dLog -> dLog.getActive().equals("A"));
    }

    @GetMapping("/list/inactive")
    public Flux<LegalGuardian> getLegalGuardianInactive() {
        return legalGuardianRepository.findAll()
                .sort(Comparator.comparing(LegalGuardian::getId))
                .filter(dLog -> dLog.getActive().equals("I"));
    }

    @GetMapping("/{idLegalGuardian}")
    public Mono<LegalGuardian> getLegalGuardianForId(@PathVariable("idLegalGuardian") int idLegalGuardian) {
        return legalGuardianRepository.findById(idLegalGuardian);
    }

    @GetMapping("/info")
    public String informationLegalGuardian() {
        return "Carlos Sanchez Alcala - Legal Guardian - SOA - 2023";
    }

    @PostMapping
    public Mono<LegalGuardian> saveLegalGuardian(@RequestBody LegalGuardian legalGuardian) {
        return legalGuardianRepository.save(legalGuardian);
    }

    @PutMapping("/{idLegalGuardian}")
    public Mono<LegalGuardian> updateLegalGuardian(@RequestBody LegalGuardian legalGuardian, @PathVariable("idLegalGuardian") int idLegalGuardian) {
        return legalGuardianRepository.findById(idLegalGuardian)
                .map((lG) -> {
                    lG.setName(legalGuardian.getName());
                    lG.setFather_last_name(legalGuardian.getFather_last_name());
                    lG.setMother_last_name(legalGuardian.getMother_last_name());
                    lG.setDocumentType(legalGuardian.getDocumentType());
                    lG.setDocumentNumber(legalGuardian.getDocumentNumber());
                    lG.setAddress(legalGuardian.getAddress());
                    lG.setCell_phone(legalGuardian.getCell_phone());
                    lG.setEmail(legalGuardian.getEmail());
                    return lG;
                }).flatMap(legalGuardianRepository::save);
    }

    @PutMapping("/deletedLogical/{idLegalGuardian}")
    public Mono<LegalGuardian> deletedLogicalLegalGuardian(@PathVariable("idLegalGuardian") int idLegalGuardian) {
        return legalGuardianRepository.findById(idLegalGuardian)
                .map((dLog) -> {
                    dLog.setActive("I");
                    return dLog;
                }).flatMap(legalGuardianRepository::save);
    }

    @PutMapping("/reactivateLogical/{idLegalGuardian}")
    public Mono<LegalGuardian> reactivateLegalGuardian(@PathVariable("idLegalGuardian") int idLegalGuardian) {
        return legalGuardianRepository.findById(idLegalGuardian)
                .map((dLog) -> {
                    dLog.setActive("A");
                    return dLog;
                }).flatMap(legalGuardianRepository::save);
    }

    @DeleteMapping("/{idLegalGuardian}")
    public Mono<Void> deleteLegalGuardian(@PathVariable("idLegalGuardian") int idLegalGuardian) {
        return legalGuardianRepository.deleteById(idLegalGuardian);
    }
}
