package com.webfullstackdev.javaguides.user.controller;

import com.webfullstackdev.javaguides.user.model.User;
import com.webfullstackdev.javaguides.user.servcie.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService;
    @Autowired
    public void setUserService(UserService userService){
       this.userService = userService;
    }

    @ApiOperation(value =" fetch all user", response = User.class)
    @GetMapping("/list")
    public List<User> getUser(){
        return userService.getAllUser();
    }

    @ApiOperation(value =" post new user to queue", response = User.class)
    @PostMapping("/list")
    public User postUser(@RequestBody User user){
        return userService.postUser(user);
    }
}
