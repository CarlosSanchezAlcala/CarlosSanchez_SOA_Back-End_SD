package com.legal_guardian_soa_canete_2023.controller;

import com.legal_guardian_soa_canete_2023.model.legalGuardian;
import com.legal_guardian_soa_canete_2023.repository.legalGuardianRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/legalGuardian")
public class legalGuardianController {

    final
    legalGuardianRepository legalGuardianRepository;

    public legalGuardianController(legalGuardianRepository legalGuardianRepository) {
        this.legalGuardianRepository = legalGuardianRepository;
    }

    @GetMapping("/list")
    public Flux<legalGuardian> getLegalGuardian() {
        return legalGuardianRepository.findAll()
                .sort(Comparator.comparing(legalGuardian::getId));
    }

    @GetMapping("/list/active")
    public Flux<legalGuardian> getLegalGuardianActive() {
        return legalGuardianRepository.findAll()
                .sort(Comparator.comparing(legalGuardian::getId))
                .filter(dLog -> dLog.getActive().equals("A"));
    }

    @GetMapping("/list/inactive")
    public Flux<legalGuardian> getLegalGuardianInactive() {
        return legalGuardianRepository.findAll()
                .sort(Comparator.comparing(legalGuardian::getId))
                .filter(dLog -> dLog.getActive().equals("I"));
    }

    @GetMapping("/{idLegalGuardian}")
    public Mono<legalGuardian> getLegalGuardianForId(@PathVariable("idLegalGuardian") int idLegalGuardian) {
        return legalGuardianRepository.findById(idLegalGuardian);
    }

    @GetMapping("/info")
    public String informationLegalGuardian() {
        return "Carlos Sanchez Alcala - Legal Guardian - SOA - 2023";
    }

    @PostMapping
    public Mono<legalGuardian> saveLegalGuardian(@RequestBody legalGuardian legalGuardian) {
        return legalGuardianRepository.save(legalGuardian);
    }

    @PutMapping("/{idLegalGuardian}")
    public Mono<legalGuardian> updateLegalGuardian(@RequestBody legalGuardian legalGuardian, @PathVariable("idLegalGuardian") int idLegalGuardian) {
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
    public Mono<legalGuardian> deletedLogicalLegalGuardian(@PathVariable("idLegalGuardian") int idLegalGuardian) {
        return legalGuardianRepository.findById(idLegalGuardian)
                .map((dLog) -> {
                    dLog.setActive("I");
                    return dLog;
                }).flatMap(legalGuardianRepository::save);
    }

    @PutMapping("/reactivateLogical/{idLegalGuardian}")
    public Mono<legalGuardian> reactivateLegalGuardian(@PathVariable("idLegalGuardian") int idLegalGuardian) {
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
