package com.legal_guardian_soa_canete_2023.web;

import com.legal_guardian_soa_canete_2023.domain.dto.adolescentDto.AdolescentRequestDto;
import com.legal_guardian_soa_canete_2023.domain.dto.adolescentDto.AdolescentResponseDto;
import com.legal_guardian_soa_canete_2023.repository.AdolescentRepository;
import com.legal_guardian_soa_canete_2023.service.AdolescentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/adolescentData")
@RequiredArgsConstructor
public class AdolescentController {

    final AdolescentRepository adolescentRepository;

    final AdolescentService adolescentService;

    @GetMapping("/infoAdolescent")
    public String informationAdolescent () {
        return "Información completa sobre los adolescentes";
    }

    @GetMapping("/listData")
    public Flux<AdolescentResponseDto> getAdolescent() {
        return this.adolescentService.findAll();
    }

    @GetMapping("/listData/active")
    public Flux<AdolescentResponseDto> getAdolescentActive() {
        return this.adolescentService.findAllActive();
    }

    @GetMapping("/listData/inactive")
    public Flux<AdolescentResponseDto> getAdolescentInactive() {
        return this.adolescentService.findAllInactive();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<AdolescentResponseDto> saveAdolescentData(@RequestBody AdolescentRequestDto dto) {
        return this.adolescentService.saveNewAdolescent(dto);
    }

}
