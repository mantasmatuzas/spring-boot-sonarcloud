package com.example.springbootsonarcloud.sso.application.service;

import com.example.springbootsonarcloud.sso.api.GetUserinfoResponse;
import com.example.springbootsonarcloud.sso.domain.UserinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserinfoQueryService {

    private final UserinfoRepository userinfoRepository;

    public GetUserinfoResponse getUserinfo(String sub) {
        var user = userinfoRepository.getByUid(sub);
        return GetUserinfoResponse.builder().sub(user.getUid()).build();
    }
}
