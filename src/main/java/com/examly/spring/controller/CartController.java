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

	@PostMapping(value="/home/{user_id}")
	public boolean addToCart(
			@RequestParam("product_id") String product_id,
			@RequestParam("quantity") String Quantity,
			@PathVariable("user_id") int user_id
	){
		return cartModelServices.addProduct(product_id, Quantity, user_id);
	}
	
	@GetMapping("/cart/{id}")
	public List<CartModel> showCart(@PathVariable int user_id){
		return cartModelServices.getCartItems(user_id);
	}
	@PostMapping(value="/cart/delete/{id}")
	public void deleteCartItem(@PathVariable String cart_item_id) {
		cartModelServices.deleteItem(Integer.parseInt(cart_item_id));
	}
}
