package com.example.demo.service;

import com.example.demo.mapper.UserCountMapper;
import com.example.demo.mapper.UtilMapper;
import com.example.demo.service.Imply.UserCountply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCountService implements UserCountply {

    @Autowired
    private UserCountMapper userCountMapper;
    @Autowired
    private UtilMapper utilMapper;
    @Override
    public Integer changeName(int userId, String newName) {
        Integer userIdExist=utilMapper.userIdExist(userId);
        Integer userNameExist=utilMapper.selectUserId(newName);
        //Id存在且新的用户名要不存在
        if(userIdExist!=null && userNameExist==null){
            return userCountMapper.changeName(userId, newName);
        }
        return null;
    }

    @Override
    public Integer changePassword(int userId, String newPassword,String oldPassword) {
        Integer userIdExist=utilMapper.userIdExist(userId);
        Integer oldPasswordExist=utilMapper.PasswordExist(oldPassword,userId);
        if(userIdExist!=null&&oldPasswordExist!=null){
            return userCountMapper.changePassword(userId, newPassword);
        }
        return null;
    }

}
