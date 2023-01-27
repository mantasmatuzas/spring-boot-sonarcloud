package com.example.springbootsonarcloud.application.rest;

import com.example.springbootsonarcloud.application.service.UserinfoQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.example.springbootsonarcloud.application.service.UserinfoQueryService.GetUserinfoResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sso/userinfo")
public class UserinfoApi {

    private final UserinfoQueryService userinfoQueryService;

    @GetMapping
    public GetUserinfoResponse getUserinfo() {
        var sub = UUID.randomUUID().toString();
        return userinfoQueryService.getUserinfo(sub);
    }
}
