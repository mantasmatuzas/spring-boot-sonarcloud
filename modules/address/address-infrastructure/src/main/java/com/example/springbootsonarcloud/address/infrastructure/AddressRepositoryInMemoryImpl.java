package com.example.springbootsonarcloud.address.infrastructure;

import com.example.springbootsonarcloud.address.domain.Address;
import com.example.springbootsonarcloud.address.domain.AddressRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
class AddressRepositoryInMemoryImpl implements AddressRepository {

    @Override
    public Address getByUid(String uid) {
        return new Address().setId(UUID.randomUUID().toString())
                .setOwnerUid(uid)
                .setAddressLine1("123 Main St.")
                .setCity("Anytown")
                .setCountry("USA");
    }
}
