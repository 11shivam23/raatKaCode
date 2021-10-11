package com.examly.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.LoginModel;
import com.examly.spring.repository.LoginRepository;

@Service
public class LoginServices {
	
	@Autowired 
	private LoginRepository loginRepository;

	public boolean checkUsermodel(LoginModel login) {
		String email = login.getEmail();
		String password = login.getPassword();
		if(loginRepository.existsByEmail(email) && loginRepository.existsByPassword(password))
			return true;
		return false;
	}
	
}
