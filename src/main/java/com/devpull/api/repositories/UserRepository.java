package com.devpull.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.devpull.api.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username); 
}
