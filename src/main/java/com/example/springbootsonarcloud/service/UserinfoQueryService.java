package com.example.springbootsonarcloud.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserinfoQueryService {

    public GetUserinfoResponse getUserinfo(String uid) {
        return GetUserinfoResponse.builder().uid(uid).build();
    }

    @Value
    @Builder
    public static class GetUserinfoResponse {

        @NonNull
        String uid;
    }
}
