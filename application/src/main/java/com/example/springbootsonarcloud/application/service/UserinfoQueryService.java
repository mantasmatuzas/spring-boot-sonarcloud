package com.example.springbootsonarcloud.application.service;

import com.example.springbootsonarcloud.application.domain.UserRepository;
import com.example.springbootsonarcloud.sso.api.GetUserinfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserinfoQueryService {

    private final UserRepository userRepository;

    public GetUserinfoResponse getUserinfo(String sub) {
        var user = userRepository.getByUid(sub);
        var fullName = user.getFullName().asString();
        return GetUserinfoResponse.builder().sub(user.getUid()).name(fullName).build();
    }
}
