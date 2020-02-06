package com.wang.myblog.service.impl;

import com.wang.myblog.dao.UserMapper;
import com.wang.myblog.entity.User;
import com.wang.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsers(){
        return userMapper.getUsers();
    }

    @Override
    public User getUser(User user){ return userMapper.getUser(user); }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public User searchUserByName(String username) {
        return userMapper.searchUserByName(username);
    }
}
