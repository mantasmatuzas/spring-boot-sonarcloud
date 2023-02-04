package com.example.springbootsonarcloud.address.api;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetAddressResponse {
    String addressLine1;
    String city;
    String country;
}
