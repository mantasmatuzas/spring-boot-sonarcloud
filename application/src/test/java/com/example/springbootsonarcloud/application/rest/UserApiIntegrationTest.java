package com.example.springbootsonarcloud.application.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserApiIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void shouldReturnUserinfo() {
        webTestClient.get()
                .uri("/user/current")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.uid")
                .isNotEmpty()
                .jsonPath("$.firstName")
                .isEqualTo("John")
                .jsonPath("$.lastName")
                .isEqualTo("Doe");
    }
}
