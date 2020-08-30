package com.webfullstackdev.javaguides.userProfile.dao;

import com.webfullstackdev.javaguides.userProfile.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileDao extends JpaRepository <UserProfile, Long> {
    UserProfile findFirstByUserProfileId(String u_P_Id);
}
