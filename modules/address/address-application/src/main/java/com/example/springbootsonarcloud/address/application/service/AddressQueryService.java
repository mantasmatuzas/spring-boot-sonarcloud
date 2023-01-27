package com.example.springbootsonarcloud.address.application.service;

import com.example.springbootsonarcloud.address.api.GetAddressResponse;
import com.example.springbootsonarcloud.address.domain.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressQueryService {

    private final AddressRepository addressRepository;

    public GetAddressResponse getByUid(String uid) {
        var address = addressRepository.getByUid(uid);
        return GetAddressResponse.builder()
                .addressLine1(address.getAddressLine1())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }
}
