package com.example.springbootsonarcloud.address.infrastructure;

import com.example.springbootsonarcloud.address.domain.Address;
import com.example.springbootsonarcloud.address.domain.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AddressRepositoryImpl extends AddressRepository {

    private final AddressMapper addressMapper;

    @Override
    public Optional<Address> getByUid(String uid) {
        return Optional.ofNullable(addressMapper.byUid(uid));
    }
}
