package com.example.springbootsonarcloud.repository;

import com.example.springbootsonarcloud.domain.User;
import com.example.springbootsonarcloud.domain.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryInMemoryImpl implements UserRepository {

    @Override
    public User getUserByUid(String uid) {
        return new User().setUid(uid).setName("John");
    }
}
