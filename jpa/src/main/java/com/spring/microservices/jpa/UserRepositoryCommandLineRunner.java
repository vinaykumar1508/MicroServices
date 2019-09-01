package com.spring.microservices.jpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.microservices.jpa.entity.User;
import com.spring.microservices.jpa.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user= new User("jill", "Admin");
		userRepository.save(user);
		log.info("New user is created:"+ user);
		
		Optional<User> userById= userRepository.findById(1L);
		log.info("user by id 1: " +userById);
		
		List<User> allUsersList= userRepository.findAll();
		log.info("allUsersList: " +allUsersList);
		
		
	}
	
	

}
