package com.example.springbootsonarcloud.sso.domain;

public interface UserinfoRepository {
    Userinfo getByUid(String uid);
}
