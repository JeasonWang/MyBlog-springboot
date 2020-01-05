package com.wang.myblog.controller;

import com.wang.myblog.entity.User;
import com.wang.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class HelloController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public int hello(){
        return 1;
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> users = userService.getUsers();
        System.out.println(users.size());
        return users;
    }
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id){
        System.out.println("id = [" + id + "]");
        return userService.getUserById(id);
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public int addUser(@RequestBody User user){
        System.out.println("add user"+user.getUsername());
        return userService.addUser(user);
    }
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public int deleteUser(@PathVariable int id){
        System.out.println("id = [" + id + "]");
        return userService.deleteUserById(id);
    }
    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public int updateUser(@RequestBody User user){
        System.out.println("user = [" + user + "]");
        return userService.updateUser(user);
    }
}
