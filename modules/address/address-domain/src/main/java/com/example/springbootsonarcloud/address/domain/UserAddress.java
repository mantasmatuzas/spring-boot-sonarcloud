package com.example.springbootsonarcloud.address.domain;

import com.example.springbootsonarcloud.shared.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAddress {
    private UserId userId;
    private String addressLine1;
    private String city;
    private String country;

    public static UserAddress assign(UserId userId, String addressLine1, String city, String country) {
        return new UserAddress(userId, addressLine1, city, country);
    }
}
