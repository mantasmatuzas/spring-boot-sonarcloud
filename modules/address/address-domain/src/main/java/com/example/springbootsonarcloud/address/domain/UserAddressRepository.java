package com.example.springbootsonarcloud.address.domain;

import com.example.springbootsonarcloud.shared.UserId;

import java.util.Optional;

public interface UserAddressRepository {
    Optional<UserAddress> findByUserId(UserId userId);

    void store(UserAddress userAddress);
}
