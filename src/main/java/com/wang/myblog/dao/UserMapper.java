package com.wang.myblog.dao;

import com.wang.myblog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public List<User> getUsers();
}
