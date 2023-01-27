package com.example.springbootsonarcloud.sso.application.service;

import com.example.springbootsonarcloud.sso.domain.Userinfo;
import com.example.springbootsonarcloud.sso.domain.UserinfoRepository;
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
    private UserinfoRepository userinfoRepository;

    @InjectMocks
    private UserinfoQueryService target;

    @Test
    void shouldReturnUserinfo() {
        var sub = "uid";
        var user = new Userinfo().setUid(sub);

        doReturn(user).when(userinfoRepository).getByUid(any());

        var response = target.getUserinfo(sub);

        assertThat(response.getSub()).isEqualTo(sub);
    }
}
