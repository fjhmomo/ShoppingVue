package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserCountMapper {

    @Update("update shopping.login set username=#{newName} where id=#{userId}")
    Integer changeName(int userId, String newName);

    @Update("update shopping.login set password=#{newPassword} where id=#{userId}")
    Integer changePassword(int userId, String newPassword);
}
