package com.wang.myblog.dao;

import com.wang.myblog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> getUsers();
    User getUserById(int id);
    int updateUser(User user);
    int addUser(User user);
    int deleteUserById(int id);
    User searchUserByName(String  username);
}
