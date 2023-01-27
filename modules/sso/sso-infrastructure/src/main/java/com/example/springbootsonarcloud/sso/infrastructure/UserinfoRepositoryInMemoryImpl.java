package com.example.springbootsonarcloud.sso.infrastructure;

import com.example.springbootsonarcloud.sso.domain.Userinfo;
import com.example.springbootsonarcloud.sso.domain.UserinfoRepository;
import org.springframework.stereotype.Repository;

@Repository
class UserinfoRepositoryInMemoryImpl implements UserinfoRepository {

    @Override
    public Userinfo getByUid(String uid) {
        return new Userinfo().setUid(uid);
    }
}
