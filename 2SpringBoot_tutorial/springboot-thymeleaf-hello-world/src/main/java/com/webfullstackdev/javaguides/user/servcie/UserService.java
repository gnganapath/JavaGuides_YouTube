package com.webfullstackdev.javaguides.user.servcie;

import com.webfullstackdev.javaguides.user.dao.UserDao;
import com.webfullstackdev.javaguides.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    UserDao userDao;
    @Autowired
    private void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public List<User> getAllUser(){
        return userDao.findAll();
    }

    public User postUser(User newUser){
        return userDao.save(newUser);
    }
}
