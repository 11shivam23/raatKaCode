package com.examly.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.LoginModel;
import com.examly.spring.repository.LoginModelRepository;

@Service
public class LoginModelServices {
	
	@Autowired 
	private LoginModelRepository loginModelRepository; 

	public boolean checkUsermodel(LoginModel login) {
		String email = login.getEmail();
		String password = login.getPassword();
		if(loginModelRepository.existsByEmail(email) && loginModelRepository.existsByPassword(password))
			return true;
		return false;
	}
	
}
