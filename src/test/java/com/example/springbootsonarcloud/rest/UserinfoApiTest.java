package com.example.springbootsonarcloud.rest;

import com.example.springbootsonarcloud.service.UserinfoQueryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.springbootsonarcloud.service.UserinfoQueryService.GetUserinfoResponse;
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
        var uid = "uid";
        var name = "John";
        var userinfoResponse = GetUserinfoResponse.builder().uid(uid).name(name).build();

        doReturn(userinfoResponse).when(userinfoQueryService).getUserinfo(any());

        var response = target.getUserinfo();

        assertThat(response.getUid()).isEqualTo(uid);
        assertThat(response.getName()).isEqualTo(name);

        verify(userinfoQueryService).getUserinfo(anyString());
    }
}
