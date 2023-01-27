package com.example.springbootsonarcloud.address.domain;

public interface AddressRepository {
    Address getByUid(String uid);
}
