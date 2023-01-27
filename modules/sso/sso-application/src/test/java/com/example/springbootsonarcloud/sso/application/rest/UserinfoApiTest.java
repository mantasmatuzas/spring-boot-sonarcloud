package com.example.springbootsonarcloud.sso.application.rest;

import com.example.springbootsonarcloud.sso.api.GetUserinfoResponse;
import com.example.springbootsonarcloud.sso.application.service.UserinfoQueryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserinfoApiTest {

    @Mock
    private UserinfoQueryService userinfoQueryService;

    @InjectMocks
    private UserinfoApi target;

    @Test
    void shouldReturnUserinfo() {
        var sub = "uid";
        var userinfoResponse = GetUserinfoResponse.builder().sub(sub).build();

        doReturn(userinfoResponse).when(userinfoQueryService).getUserinfo(any());

        var response = target.getUserinfo();

        assertThat(response.getSub()).isEqualTo(sub);

        verify(userinfoQueryService).getUserinfo(anyString());
    }
}
