package com.examly.spring.services;

import java.util.List;
import java.util.Optional;

import com.examly.spring.model.CartModel;
import com.examly.spring.repository.CartModelRepository;
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

	@Autowired
	private CartModelRepository cartModelRepository;
		

	public List<UserModel> getAll(){
		return userModelRepository.findAll();
	}

	public Optional<UserModel> getUserById(int id) {
		return userModelRepository.findByUserId(id);
	}
	
	public boolean saveUserModel(UserModel user){
			String email=user.getEmail();
			String password=user.getPassword();
			Integer mobileNumber=user.getMobileNumber();
			if(!userModelRepository.existsByEmail(email) && !userModelRepository.existsByMobileNumber(mobileNumber)){
				CartModel cart = new CartModel();
				cart.setUser(user);
				user.setCart(cart);
				userModelRepository.save(user);
				System.out.print("Yahan");
				cartModelRepository.save(cart);
				System.out.print("Wahan");
				LoginModel login = new LoginModel(email,password);
				loginModelRepository.save(login);
				return true;
			}
			return false;	
	}
}
