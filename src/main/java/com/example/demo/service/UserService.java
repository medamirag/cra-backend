package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.userDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public userDto getUser(User user) {
		userDto userDto= new userDto();
		System.out.println(user);
		User myUser= userRepository.findByUsername(user.getUsername());
		if(myUser==null) {
			userDto.setMessage("User not found");
		}
		else if(!myUser.getPassword().equals(user.getPassword())) {
			userDto.setMessage("wrong password");

		}
		else {
		userDto.setMessage("OK");
		userDto.setId(myUser.getId());
		}
		 return userDto;
	}
	public User getUserByID(Long id) {
		return userRepository.findById(id).orElse(null);
	}
}
