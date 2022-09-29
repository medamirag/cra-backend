package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.userDto;
import com.example.demo.entity.Evenement;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("User")
@CrossOrigin
public class UserController {
@Autowired
UserService userService;
	
	@PostMapping("/")
	public userDto getUser(@RequestBody User user) {
		return userService.getUser(user);

	}
}
