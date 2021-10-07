package com.examly.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.spring.model.CartModel;
import com.examly.spring.services.CartModelServices;

@RestController
public class CartController {
	
	@Autowired
	CartModelServices cartModelServices;
	
	@PostMapping(value="/home/{userId}")
	public void addToCart(@RequestBody CartModel cart, @PathVariable int userId){
		cartModelServices.addProduct(cart,userId);
	}
	
	@GetMapping("/cart/{id}")
	public List<CartModel> showCart(@PathVariable int userId){
		return cartModelServices.getCartItems(userId);
	}
	@PostMapping(value="/cart/delete")
	public void deleteCartItem(@PathVariable String cartItemId) {
		cartModelServices.deleteItem(cartItemId);
	}
}
