package com.example.springbootsonarcloud.address.domain;

import java.util.Optional;

public abstract class AddressRepository {
    public abstract Optional<Address> getByUid(String uid);
}
