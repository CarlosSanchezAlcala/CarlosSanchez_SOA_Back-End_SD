package com.legal_guardian_soa_canete_2023.web;

import com.legal_guardian_soa_canete_2023.domain.dto.legalGuardianDto.LegalGuardianRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.legalGuardianDto.LegalGuardianResponseDto;
import com.legal_guardian_soa_canete_2023.repository.LegalGuardianRepository;
import com.legal_guardian_soa_canete_2023.service.LegalGuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/legalGuardian")
@RequiredArgsConstructor
public class LegalGuardianController {

    final LegalGuardianService legalGuardianService;

    final LegalGuardianRepository legalGuardianRepository;

    @GetMapping("/list")
    public Flux<LegalGuardianResponseDto> getLegalGuardian() {
        return this.legalGuardianService.findAll();
    }

    @GetMapping("/list/active")
    public Flux<LegalGuardianResponseDto> getLegalGuardianActive() {
        return this.legalGuardianService.findAllActive();
    }

    @GetMapping("/list/inactive")
    public Flux<LegalGuardianResponseDto> getLegalGuardianInactive() {
        return this.legalGuardianService.findAllInactive();
    }

    @GetMapping("/{idLegalGuardian}")
    public Mono<LegalGuardianResponseDto> getLegalGuardianForId(@PathVariable Integer idLegalGuardian) {
        return this.legalGuardianService.findById(idLegalGuardian);
    }

    @GetMapping("/info")
    public String informationLegalGuardian() {
        return "Carlos Sanchez Alcala - Legal Guardian - SOA - 2023";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<LegalGuardianResponseDto> saveLegalGuardian(@RequestBody LegalGuardianRequestDto dto) {
        return this.legalGuardianService.saveNewLegalGuardian(dto);
    }

    @PutMapping("/{idLegalGuardian}")
    public Mono<LegalGuardianResponseDto> updateLegalGuardian(@RequestBody LegalGuardianRequestDto dto, @PathVariable Integer idLegalGuardian) {
        return this.legalGuardianService.updateLegalGuardian(dto, idLegalGuardian);
    }

    @PutMapping("/deletedLogical/{idLegalGuardian}")
    public Mono<LegalGuardianResponseDto> deletedLogicalLegalGuardian(@PathVariable Integer idLegalGuardian) {
        return this.legalGuardianService.deleteLogicalLegalGuardian(idLegalGuardian);
    }

    @PutMapping("/reactivateLogical/{idLegalGuardian}")
        public Mono<LegalGuardianResponseDto> reactivateLegalGuardian(@PathVariable Integer idLegalGuardian) {
        return this.legalGuardianService.reactiveLogicalLegalGuardian(idLegalGuardian);
    }

    @DeleteMapping("/{idLegalGuardian}")
    public Mono<Void> deleteLegalGuardian(@PathVariable Integer idLegalGuardian) {
        return this.legalGuardianService.deleteLegalGuardian(idLegalGuardian);
    }
}
