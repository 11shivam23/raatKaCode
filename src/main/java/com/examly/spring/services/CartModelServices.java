package com.examly.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.CartModel;
import com.examly.spring.repository.CartModelRepository;

@Service
public class CartModelServices {
	
	@Autowired
	private CartModelRepository cartModelRepository;

	public void addProduct(CartModel cart, int userId ){
		
		cartModelRepository.save(cart);
	}

	public List<CartModel> getCartItems(int userId) {
		List<CartModel> cartModel = new ArrayList<>();
//		cartModelRepository.getUserModelByUserId(userId)
//		.forEach(cartModel::add);
		return cartModel;
	}

	public void deleteItem(String cartItemId) {
		cartModelRepository.deleteById(cartItemId);
		
	}
}
	

