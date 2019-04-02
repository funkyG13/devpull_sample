package com.devpull.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devpull.api.model.User;
import com.devpull.api.repositories.UserRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public String addUserByAdmin(@RequestBody User user) {
		String pass = user.getPassword();
		String encryptPass = bCryptPasswordEncoder.encode(pass);
		user.setPassword(encryptPass);
		userRepository.save(user);
		return "user added succesfully";
	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured")
	public String secureHello() {
		return "secure HII";
		
	}
}
