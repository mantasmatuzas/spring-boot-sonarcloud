package com.example.springbootsonarcloud.rest;

import com.example.springbootsonarcloud.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/current")
public class UserApi {

    private final UserQueryService userQueryService;

    @GetMapping
    public UserQueryService.GetUserResponse getCurrentUser() {
        return userQueryService.getUser(UUID.randomUUID().toString());
    }
}
