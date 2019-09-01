package com.spring.microservices.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.microservices.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
