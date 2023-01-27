package com.example.springbootsonarcloud.application.service;

import com.example.springbootsonarcloud.application.domain.UserRepository;
import com.example.springbootsonarcloud.user.api.GetUserResponse;
import lombok.RequiredArgsConstructor;
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
}
