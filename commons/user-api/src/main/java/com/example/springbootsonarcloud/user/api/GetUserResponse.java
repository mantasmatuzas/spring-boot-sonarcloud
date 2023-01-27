package com.example.springbootsonarcloud.user.api;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class GetUserResponse {
    @NonNull String uid;
    @NonNull String firstName;
    @NonNull String lastName;
}
