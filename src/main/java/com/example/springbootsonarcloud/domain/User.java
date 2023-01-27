package com.example.springbootsonarcloud.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private String uid;
    private String name;
}
