package com.example.springbootsonarcloud.service;

import com.example.springbootsonarcloud.domain.User;
import com.example.springbootsonarcloud.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserinfoQueryServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserinfoQueryService target;

    @Test
    void shouldReturnUserinfo() {
        var uid = "uid";
        var name = "John";
        var user = new User().setUid(uid).setName(name);

        doReturn(user).when(userRepository).getUserByUid(any());

        var response = target.getUserinfo(uid);

        assertThat(response.getUid()).isEqualTo(uid);
        assertThat(response.getName()).isEqualTo(name);
    }
}
