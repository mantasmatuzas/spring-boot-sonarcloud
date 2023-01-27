package com.example.springbootsonarcloud.service;

import com.example.springbootsonarcloud.domain.FullName;
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
        var sub = "sub";
        var firstName = "John";
        var lastName = "Doe";
        var fullName = new FullName(firstName, lastName);
        var user = new User().setUid(sub).setFullName(fullName);

        doReturn(user).when(userRepository).getByUid(any());

        var response = target.getUserinfo(sub);

        assertThat(response.getSub()).isEqualTo(sub);
        assertThat(response.getName()).isEqualTo(fullName.asString());
    }
}
