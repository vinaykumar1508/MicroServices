package com.example.spring.test.spring.security.test1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
}
