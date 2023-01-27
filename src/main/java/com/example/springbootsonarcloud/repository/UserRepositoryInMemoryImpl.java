package com.example.springbootsonarcloud.repository;

import com.example.springbootsonarcloud.domain.FullName;
import com.example.springbootsonarcloud.domain.User;
import com.example.springbootsonarcloud.domain.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryInMemoryImpl implements UserRepository {

    @Override
    public User getByUid(String uid) {
        var fullName = new FullName("John", "Doe");
        return new User().setUid(uid).setFullName(fullName);
    }
}
