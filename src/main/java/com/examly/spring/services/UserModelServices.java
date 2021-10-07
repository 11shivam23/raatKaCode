package com.examly.spring.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.LoginModel;
import com.examly.spring.model.UserModel;
import com.examly.spring.repository.LoginModelRepository;
import com.examly.spring.repository.UserModelRepository;

@Service
public class UserModelServices {
	
	@Autowired
	private UserModelRepository userModelRepository;
	
	@Autowired 
	private LoginModelRepository loginModelRepository; 
		

	public List<UserModel> getAll(){
		return userModelRepository.findAll();
	}
	
	public boolean saveUserModel(UserModel user){
			int userId = user.getUserId();
			String email=user.getEmail();
			String password=user.getPassword();
			String mobileNumber=user.getMobileNumber();
			if(!userModelRepository.existsByUserId(userId) && !userModelRepository.existsByEmail(email) && !userModelRepository.existsByMobileNumber(mobileNumber)){
				userModelRepository.save(user);
				
				LoginModel login = new LoginModel(email,password);
				loginModelRepository.save(login);
				return true;
			}
			return false;	
	}
}
