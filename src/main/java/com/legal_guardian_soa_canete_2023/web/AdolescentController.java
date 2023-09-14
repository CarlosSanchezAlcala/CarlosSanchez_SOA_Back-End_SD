package com.legal_guardian_soa_canete_2023.web;

import com.legal_guardian_soa_canete_2023.domain.model.Adolescent;
import com.legal_guardian_soa_canete_2023.repository.AdolescentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/adolescentData")
@RequiredArgsConstructor
public class AdolescentController {

    final
    AdolescentRepository adolescentRepository;

    @GetMapping("/infoAdolescent")
    public String informationAdolescent () {
        return "Información completa sobre los adolescentes";
    }

    @GetMapping("/listData")
    public Flux<Adolescent> getAdolescent() {
        return adolescentRepository.findAll()
                .sort(Comparator.comparing(Adolescent::getId));
    }

    @PostMapping
    public Mono<Adolescent> saveAdolescentData(@RequestBody Adolescent adolescent) {
        return adolescentRepository.save(adolescent);
    }

}
