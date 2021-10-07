package com.examly.spring.services;

import java.util.ArrayList;
import java.util.List;

import com.examly.spring.model.ProductModel;
import com.examly.spring.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.CartModel;
import com.examly.spring.repository.CartModelRepository;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class CartModelServices {
	
	@Autowired
	private CartModelRepository cartModelRepository;

	@Autowired
	ProductModelServices productModelServices;

	@Autowired
	UserModelServices userModelServices;


	public void addProduct(ProductModel product, CartModel cart, int Quantity){
		while(Quantity-- == 0)
			cart.addProduct(product);
		cartModelRepository.save(cart);
	}

	public void addProduct(String productId, int userId, String Quantity) {
		ProductModel product;
		CartModel cart;
		try {
			product = productModelServices.getProductById(Integer.parseInt(productId)).get();
			UserModel user = userModelServices.getUserById(userId).get();
			cart = cartModelRepository.getCartByUser(user);
			addProduct(product, cart, Integer.parseInt(Quantity));
		}
		catch(Exception e){
			System.out.println("No product or user found for given id");
		}
	}

	public List<CartModel> getCartItems(int userId) {
		List<CartModel> cartModel = new ArrayList<>();
//		cartModelRepository.getUserModelByUserId(userId)
//		.forEach(cartModel::add);
		return cartModel;
	}

	public void deleteItem(Integer cartItemId) {
		cartModelRepository.deleteById(cartItemId);
		
	}
}
	

