package com.example.springbootsonarcloud.address.application.rest;

import com.example.springbootsonarcloud.address.api.GetAddressResponse;
import com.example.springbootsonarcloud.address.application.service.AddressQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressApi {

    private final AddressQueryService addressQueryService;

    @GetMapping(params = "uid")
    public GetAddressResponse getByUid(@RequestParam("uid") String uid) {
        return addressQueryService.getByUid(uid);
    }
}
