package com.example.springbootsonarcloud.service;

import com.example.springbootsonarcloud.domain.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;
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

    @Value
    @Builder
    public static class GetUserinfoResponse {

        @NonNull
        String sub;

        @NonNull
        String name;
    }
}
