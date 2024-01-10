package com.example.demo.mapper;


import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    //根据账号密码查询
    @Select("select * from shopping.login where username=#{username} and password=#{password}")
    public User getUser(String username, String password);

    @Select("select * from shopping.login where username=#{username}")
    public User getName(String username);

    @Insert("insert into shopping.login (username, password)" +
            "values (#{username}, #{password})")
    boolean createUser(String username, String password);
}
