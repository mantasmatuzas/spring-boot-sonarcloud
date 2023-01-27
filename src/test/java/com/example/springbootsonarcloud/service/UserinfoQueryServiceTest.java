package com.example.springbootsonarcloud.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserinfoQueryServiceTest {

    @InjectMocks
    private UserinfoQueryService target;

    @Test
    void shouldReturnUserinfo() {
        var uid = "uid";

        var response = target.getUserinfo(uid);

        assertThat(response.getUid()).isEqualTo(uid);
    }
}
