package com.example.springbootsonarcloud.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class AddressApiIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void shouldReturnUserinfo() {
        webTestClient.get()
                .uri(uri -> uri.path("/addresses").queryParam("uid", "123").build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.addressLine1")
                .isEqualTo("123 Main St.");
    }
}
