package com.example.springbootsonarcloud.address.api;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class GetAddressResponse {
    @NonNull String addressLine1;
    @NonNull String city;
    @NonNull String country;
}
