package com.sanjana.orders.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanjana.orders.order.entity.User;
import com.sanjana.orders.order.services.UserService;

@RestController
public class UsersController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.createAndUpdateUser(user);
	}
}
