package com.legal_guardian_soa_canete_2023.web;

import com.legal_guardian_soa_canete_2023.domain.dto.TransactionalDataDto;
import com.legal_guardian_soa_canete_2023.domain.dto.familyDto.FamilyRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.familyDto.FamilyResponseDto;
import com.legal_guardian_soa_canete_2023.repository.FamilyRepository;
import com.legal_guardian_soa_canete_2023.service.FamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
@RequestMapping("/api/familyData")
@RequiredArgsConstructor
public class FamilyController {

    final FamilyRepository familyRepository;

    final FamilyService familyService;

    @GetMapping("/infoFamily")
    public String informationAdolescent() {
        return "Información completa sobre las familia formadas";
    }

    @GetMapping("/list")
    public Flux<TransactionalDataDto> getDataFamily() {
        return this.familyService.findAll();
    }

    @GetMapping("/{idFamilyData}")
    public Mono<TransactionalDataDto> getDataTransactionalFamily(@PathVariable Integer idFamilyData) {
        return familyService.findById(idFamilyData);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<FamilyResponseDto> saveNewFamily(@RequestBody FamilyRequestDto dto) {
        return this.familyService.saveNewFamily(dto);
    }

}
