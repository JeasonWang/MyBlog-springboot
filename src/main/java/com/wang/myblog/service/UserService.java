package com.wang.myblog.service;

import com.wang.myblog.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public User getUserById(int id);
    public int updateUser(User user);
    public int addUser(User user);
    public int deleteUserById(int id);
    public User searchUserByName(String  username);
}
