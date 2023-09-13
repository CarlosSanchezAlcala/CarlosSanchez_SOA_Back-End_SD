package com.legal_guardian_soa_canete_2023;

import com.legal_guardian_soa_canete_2023.model.legalGuardian;
import com.legal_guardian_soa_canete_2023.repository.legalGuardianRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@AutoConfigureWebTestClient
class LegalGuardianSoaCanete2023ApplicationTests {

    @Autowired
    legalGuardianRepository legalGuardianRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateLegalGuardian() {
        legalGuardian newLegalGuardian = new legalGuardian(
                "Jose Jose",
                "Alcantara",
                "Minu",
                "DNI",
                "52412563",
                "Sin dirección exacta",
                "965802147",
                "789456@gmail.com",
                "A");

        webTestClient.post()
                .uri("/api/legalGuardian")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(newLegalGuardian), legalGuardian.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(legalGuardian.class)
                .value(legalGuardian::getId, notNullValue())
                .value(legalGuardian::getName, equalTo("Jose Jose"))
                .value(legalGuardian::getFather_last_name, equalTo("Alcantara"))
                .value(legalGuardian::getMother_last_name, equalTo("Minu"))
                .value(legalGuardian::getDocumentType, equalTo("DNI"))
                .value(legalGuardian::getDocumentNumber, equalTo("52412563"))
                .value(legalGuardian::getAddress, equalTo("Sin dirección exacta"))
                .value(legalGuardian::getCell_phone, equalTo("965802147"))
                .value(legalGuardian::getEmail, equalTo("789456@gmail.com"));
    }

    @Test
    public void testListLegalGuardian() {
        webTestClient.get().uri("/api/legalGuardian/list")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(legalGuardian.class)
                .consumeWith(response -> {
                    List<legalGuardian> dataList = response.getResponseBody();
                    assertTrue("La lista no debe de estar vacía: ", dataList != null && !dataList.isEmpty());
                    assertTrue("La lista debe contener al menos " + 1 + " elementos", dataList.size() >= 1);
                    System.out.println(dataList);
                });


    }

    @Test
    public void testListInactiveLegalGuardian() {
        webTestClient.get().uri("/api/legalGuardian/list/inactive")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(legalGuardian.class)
                .consumeWith(response -> {
                    List<legalGuardian> dataList = response.getResponseBody();
                    assertTrue("La lista no debe de estar vacía: ", dataList != null && !dataList.isEmpty());
                    assertTrue("La lista debe contener al menos " + 1 + " elementos", dataList.size() >= 1);
                });

    }

    @Test
    public void testListActiveLegalGuardian() {
        webTestClient.get().uri("/api/legalGuardian/list/active")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(legalGuardian.class)
                .consumeWith(response -> {
                    List<legalGuardian> dataList = response.getResponseBody();
                    Assertions.assertTrue(dataList != null && !dataList.isEmpty(), "La lista no debe de estar vacía: ");
                    Assertions.assertTrue(true, "La lista debe contener al menos " + 1 + " elementos");
                });

    }

    @ParameterizedTest
    @ValueSource(ints = {21})
    public void testUpdateLegalGuardian(int dataId) {
        legalGuardian UpdateLegalGuardian = new legalGuardian(
                "Carla Alejandra",
                "Sanchez",
                "Sanchez",
                "DNI",
                "45781478",
                "Sin dirección exacta",
                "985478001",
                "CarlaMasNada@gmail.com",
                "A");

        webTestClient.put().uri("/api/legalGuardian/{id}", dataId)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(UpdateLegalGuardian)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(legalGuardian.class)
                .consumeWith(response -> {
                    legalGuardian updatedData = response.getResponseBody();
                });
    }
}

