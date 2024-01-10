package com.example.demo.service;

import com.example.demo.mapper.LoginMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.Imply.*;
@Service
public class LoginService implements LoginServiceply {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public boolean registerUser(String username, String password) {
        User user = loginMapper.getUser(username, password);
        //没有查找到用户则进行一个注册
        if(user == null){
            return loginMapper.createUser(username, password);
        }
        return false;
    }

    @Override
    public User loginUser(String username, String password) {
        User haveUser = loginMapper.getName(username);
        if(haveUser == null){
            return new User(username, password,0);
        }
        System.out.println(loginMapper.getUser(username, password));
        return loginMapper.getUser(username, password);
    }
}
