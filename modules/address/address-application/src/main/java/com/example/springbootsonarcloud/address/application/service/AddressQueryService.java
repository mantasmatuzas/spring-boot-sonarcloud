package com.example.springbootsonarcloud.address.application.service;

import com.example.springbootsonarcloud.address.api.GetAddressResponse;
import com.example.springbootsonarcloud.address.domain.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AddressQueryService {

    private final AddressRepository addressRepository;

    public GetAddressResponse getByUid(String uid) {
        return addressRepository.getByUid(uid)
                .map(address -> GetAddressResponse.builder()
                        .addressLine1(address.getAddressLine1())
                        .city(address.getCity())
                        .country(address.getCountry())
                        .build())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
