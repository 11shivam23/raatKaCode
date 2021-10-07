package com.examly.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.spring.model.UserModel;

import com.examly.spring.services.UserModelServices;


@RestController
public class SignupController {
	
	@Autowired
	UserModelServices userModelServices;
	
	
	@PostMapping(value="/signup")
	public boolean saveUser(@RequestBody UserModel user){
			return userModelServices.saveUserModel(user);
	}


}
