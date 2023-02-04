package com.example.springbootsonarcloud.address.application.usecase;

import com.example.springbootsonarcloud.shared.UserId;

public class UserAddressAlreadyExists extends RuntimeException {

    public UserAddressAlreadyExists(UserId userId) {
        super(String.format("User %s already has address assigned", userId.id()));
    }
}
