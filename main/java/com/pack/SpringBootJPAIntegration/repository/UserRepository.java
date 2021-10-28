package com.pack.SpringBootJPAIntegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.SpringBootJPAIntegration.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsername(String username);  //custom method start with findby
}
