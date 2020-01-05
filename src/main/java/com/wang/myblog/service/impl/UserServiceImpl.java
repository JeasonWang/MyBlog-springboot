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
    public List<User> getUsers(){
        return userMapper.getUsers();
    }
}
