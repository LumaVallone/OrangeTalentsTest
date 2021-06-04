package com.orangetalents3.orangetalents3.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents3.orangetalents3.models.User;
import com.orangetalents3.orangetalents3.repositories.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> list() {
		return userRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<User> create(@Valid @RequestBody User user) {		
		User createdUser = userRepository.save(user);
		return ResponseEntity.ok(createdUser);
	}

}
