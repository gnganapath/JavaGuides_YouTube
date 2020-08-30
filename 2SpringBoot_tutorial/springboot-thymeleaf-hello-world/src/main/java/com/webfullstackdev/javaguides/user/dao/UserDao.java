package com.webfullstackdev.javaguides.user.dao;

import com.webfullstackdev.javaguides.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findFirstByUserId(String userID);
}
