package com.example.springbootsonarcloud.address.infrastructure;

import com.example.springbootsonarcloud.address.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AddressMapper {
    @Select("SELECT * FROM address WHERE uid = #{uid}")
    Address byUid(String uid);
}
