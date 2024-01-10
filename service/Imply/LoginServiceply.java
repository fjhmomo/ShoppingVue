package com.example.demo.service.Imply;

import com.example.demo.pojo.User;

public interface LoginServiceply {

    boolean registerUser(String username, String password);

    User loginUser(String username, String password);
}
