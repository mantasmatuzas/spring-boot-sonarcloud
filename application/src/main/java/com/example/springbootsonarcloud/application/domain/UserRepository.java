package com.example.springbootsonarcloud.application.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User getByUid(String uid);
}
