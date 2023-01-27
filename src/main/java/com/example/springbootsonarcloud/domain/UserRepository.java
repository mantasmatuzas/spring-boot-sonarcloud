package com.example.springbootsonarcloud.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User getUserByUid(String uid);
}
