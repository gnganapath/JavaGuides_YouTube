package com.webfullstackdev.javaguides;

import com.webfullstackdev.javaguides.user.dao.UserDao;
import com.webfullstackdev.javaguides.user.model.User;
import com.webfullstackdev.javaguides.userProfile.dao.UserProfileDao;
import com.webfullstackdev.javaguides.userProfile.model.UserProfile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootThymeleafHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeleafHelloWorldApplication.class, args);
	}


	@Bean
	public CommandLineRunner mappingDemo(UserDao userRepository, UserProfileDao userProfileDao) {
		return args -> {

			// create a user instance
			User user = new User("John Doe", "john.doe@example.com");
//
//			// create an address instance
//			UserProfile userProfile = new UserProfile();
//
//			// set child reference
//			userProfile.setUserProfileId(user);
//
//			// set parent reference
//			user.setUser(userProfile);
//
//			// save the parent
//			// which will save the child (address) as well
//			userRepository.save(user);
		};
	}
}
