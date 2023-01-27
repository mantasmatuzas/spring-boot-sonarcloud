package com.example.springbootsonarcloud.address.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Address {
    private String id;
    private String ownerUid;
    private String addressLine1;
    private String city;
    private String country;
}
