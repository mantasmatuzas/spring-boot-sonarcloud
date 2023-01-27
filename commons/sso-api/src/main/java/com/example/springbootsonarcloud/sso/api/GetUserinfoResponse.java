package com.example.springbootsonarcloud.sso.api;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class GetUserinfoResponse {
    @NonNull String sub;
}
