package com.example.springbootsonarcloud.address.application.service;

import com.example.springbootsonarcloud.address.api.GetAddressResponse;
import com.example.springbootsonarcloud.address.domain.UserAddress;
import com.example.springbootsonarcloud.address.domain.UserAddressRepository;
import com.example.springbootsonarcloud.shared.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.function.Function;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAddressQueryService {

    private final UserAddressRepository addressRepository;

    public GetAddressResponse getByUid(UUID uid) {
        var userid = new UserId(uid);
        return addressRepository.findByUserId(userid)
                .map(mapToResponse())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private Function<UserAddress, GetAddressResponse> mapToResponse() {
        return address -> GetAddressResponse.builder()
                .addressLine1(address.getAddressLine1())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }
}
