package com.examly.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.spring.model.UserModel;

import com.examly.spring.services.UserModelServices;


@RestController
public class SignupController {
	
	@Autowired
	UserModelServices userModelServices;

	@PostMapping(value="/signup")
	public boolean saveUser(
			@RequestParam("email") String email,
			@RequestParam("mobileNumber") Integer mobileNumber,
			@RequestParam("password") String password,
			@RequestParam("username") String username
			){
		UserModel user = new UserModel();
		user.setEmail(email);
		user.setMobileNumber(mobileNumber);
		user.setPassword(password);
		user.setUsername(username);
		return userModelServices.saveUserModel(user);
	}

}
