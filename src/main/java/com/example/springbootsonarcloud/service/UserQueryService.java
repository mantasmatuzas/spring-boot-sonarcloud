package com.example.springbootsonarcloud.service;

import com.example.springbootsonarcloud.domain.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserRepository userRepository;

    public GetUserResponse getUser(String uid) {
        var user = userRepository.getByUid(uid);
        var fullName = user.getFullName();
        return GetUserResponse.builder().uid(uid).firstName(fullName.firstName()).lastName(fullName.lastName()).build();
    }

    @Value
    @Builder
    public static class GetUserResponse {
        @NonNull
        String uid;

        @NonNull
        String firstName;

        @NonNull
        String lastName;
    }
}
