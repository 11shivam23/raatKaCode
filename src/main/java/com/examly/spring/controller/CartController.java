package com.examly.spring.controller;

import java.util.List;

import com.examly.spring.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.examly.spring.model.CartModel;
import com.examly.spring.services.CartModelServices;

@RestController
public class CartController {

	@Autowired
	CartModelServices cartModelServices;

	@PostMapping(value="/home/{userId}")
	public void addToCart(
			@RequestParam("product_id") String productId,
			@RequestParam("quantity") String quantity,
			@PathVariable int userId
	){
		cartModelServices.addProduct(productId, userId, quantity);
	}
	
	@GetMapping("/cart/{id}")
	public List<CartModel> showCart(@PathVariable int userId){
		return cartModelServices.getCartItems(userId);
	}
	@PostMapping(value="/cart/delete/{id}")
	public void deleteCartItem(@PathVariable String cartItemId) {
		cartModelServices.deleteItem(Integer.parseInt(cartItemId));
	}
}
