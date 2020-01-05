package com.wang.myblog.controller;

import com.wang.myblog.entity.User;
import com.wang.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "users")
    public List<User> hello(){
        System.out.println(userService.getUsers().size());
        return userService.getUsers();
    }
}
