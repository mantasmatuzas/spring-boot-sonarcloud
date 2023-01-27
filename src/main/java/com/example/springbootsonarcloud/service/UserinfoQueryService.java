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

    public GetUserinfoResponse getUserinfo(String uid) {
        var user = userRepository.getUserByUid(uid);
        return GetUserinfoResponse.builder().uid(user.getUid()).name(user.getName()).build();
    }

    @Value
    @Builder
    public static class GetUserinfoResponse {

        @NonNull
        String uid;

        @NonNull
        String name;
    }
}
