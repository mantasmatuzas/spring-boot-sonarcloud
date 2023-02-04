package com.example.springbootsonarcloud.address.application.usecase;

import com.example.springbootsonarcloud.address.domain.UserAddress;
import com.example.springbootsonarcloud.address.domain.UserAddressRepository;
import com.example.springbootsonarcloud.shared.UserId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@Transactional
@RequiredArgsConstructor
public class AssignAddressToUser {

    private final UserAddressRepository userAddressRepository;

    public void handle(Input input) {
        var userId = new UserId(input.getUid());
        userAddressRepository.findByUserId(userId).ifPresentOrElse(unused -> {
            throw new UserAddressAlreadyExists(userId);
        }, () -> {
            var userAddress = UserAddress.assign(userId, input.getAddressLine1(), input.getCity(), input.getCountry());
            userAddressRepository.store(userAddress);
        });
    }

    @Data
    public static final class Input {
        private @JsonIgnore UUID uid;

        private final @NotBlank String addressLine1;
        private final @NotBlank String city;
        private final @NotBlank String country;
    }
}
