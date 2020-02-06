package com.wang.myblog.service;

import com.wang.myblog.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(User user);
    User getUserById(int id);
    int updateUser(User user);
    int addUser(User user);
    int deleteUserById(int id);
    User searchUserByName(String  username);
}
