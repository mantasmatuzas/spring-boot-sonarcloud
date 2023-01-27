package com.example.springbootsonarcloud.sso.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Userinfo {
    private String uid;
}
