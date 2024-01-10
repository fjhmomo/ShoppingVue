package com.example.demo.service.Imply;

public interface UserCountply {
    Integer changeName(int userId, String newName);

    Integer changePassword(int userId, String newPassword,String oldPassword);

}
