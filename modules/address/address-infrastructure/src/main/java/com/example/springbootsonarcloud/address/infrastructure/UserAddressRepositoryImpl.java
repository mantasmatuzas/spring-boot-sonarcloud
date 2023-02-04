package com.example.springbootsonarcloud.address.infrastructure;

import com.example.springbootsonarcloud.address.domain.UserAddress;
import com.example.springbootsonarcloud.address.domain.UserAddressRepository;
import com.example.springbootsonarcloud.shared.UserId;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.generated.Tables;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.jooq.generated.tables.UserAddress.USER_ADDRESS;

@Component
@RequiredArgsConstructor
public class UserAddressRepositoryImpl implements UserAddressRepository {

    private final DSLContext dslContext;

    @Override
    public Optional<UserAddress> findByUserId(UserId userId) {
        return dslContext.selectFrom(Tables.USER_ADDRESS)
                .where(USER_ADDRESS.UID.eq(userId.id()))
                .fetchOptional()
                .map(record -> new UserAddress(userId, record.getAddressLine_1(), record.getCity(), record.getCounty()));
    }

    @Override
    public void store(UserAddress userAddress) {
        var record = dslContext.newRecord(USER_ADDRESS);
        record.setUid(userAddress.getUserId().id());
        record.setAddressLine_1(userAddress.getAddressLine1());
        record.setCity(userAddress.getCity());
        record.setCounty(userAddress.getCountry());
        record.store();
    }
}
