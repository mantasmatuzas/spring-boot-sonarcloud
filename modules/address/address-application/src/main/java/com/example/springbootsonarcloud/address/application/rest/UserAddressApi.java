package com.example.springbootsonarcloud.address.application.rest;

import com.example.springbootsonarcloud.address.api.GetAddressResponse;
import com.example.springbootsonarcloud.address.application.service.UserAddressQueryService;
import com.example.springbootsonarcloud.address.application.usecase.AssignAddressToUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class UserAddressApi {

    private final UserAddressQueryService addressQueryService;

    private final AssignAddressToUser assignAddressToUser;

    @GetMapping(params = "uid")
    public GetAddressResponse getByUid(@RequestParam("uid") UUID uid) {
        return addressQueryService.getByUid(uid);
    }

    @PostMapping(params = "uid")
    public void assignAddress(@RequestParam("uid") UUID uid, @Valid @RequestBody AssignAddressToUser.Input input) {
        input.setUid(uid);
        assignAddressToUser.handle(input);
    }
}
