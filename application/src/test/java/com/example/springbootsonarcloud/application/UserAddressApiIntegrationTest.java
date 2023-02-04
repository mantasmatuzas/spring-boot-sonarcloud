package com.example.springbootsonarcloud.application;

import com.example.springbootsonarcloud.address.domain.UserAddress;
import com.example.springbootsonarcloud.address.domain.UserAddressRepository;
import com.example.springbootsonarcloud.shared.UserId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserAddressApiIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private UserAddressRepository userAddressRepository;

    private final UserId userId = new UserId(UUID.randomUUID());

    @Test
    void shouldReturnUserAddress() {
        insertUserAddress();

        webTestClient.get()
                .uri(uri -> uri.path("/addresses").queryParam("uid", userId.id()).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.addressLine1")
                .isEqualTo("123 Main St.");
    }

    private void insertUserAddress() {
        var userAddress = new UserAddress(userId, "123 Main St.", "Vilnius", "LTU");
        userAddressRepository.store(userAddress);
    }
}
