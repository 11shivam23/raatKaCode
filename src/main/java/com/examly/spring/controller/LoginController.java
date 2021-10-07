package com.examly.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.spring.model.LoginModel;
import com.examly.spring.services.LoginModelServices;

@RestController
public class LoginController {
	
	@Autowired
	LoginModelServices loginModelServices;
	
	@PostMapping(value="/login")
	boolean checkUser(@RequestBody LoginModel data) {
		return loginModelServices.checkUsermodel(data);	
	}
}
