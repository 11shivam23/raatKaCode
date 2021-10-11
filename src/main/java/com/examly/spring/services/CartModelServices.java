package com.examly.spring.services;

import java.util.ArrayList;
import java.util.List;

import com.examly.spring.model.ProductModel;
import com.examly.spring.model.UserModel;
import com.examly.spring.repository.ProductModelRepository;
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

	public boolean addProduct(ProductModel product, CartModel cart, int Quantity){
		if(Integer.parseInt(product.getQuantity()) >= Quantity){
			cart.setPrice(String.valueOf(Integer.parseInt(cart.getPrice()) + Integer.parseInt(product.getPrice())*Quantity));
			cart.addProduct(product);
			cart.addQuantity(Quantity);
			System.out.println("\n\n\n" + cart.getQuantity() + "\n\n\n");
			cartModelRepository.save(cart);
			return true;
		}
		else
			return false;
	}

	public boolean addProduct(String product_id,String Quantity, int user_id){
		ProductModel product;
		CartModel cart;

		try {
			product = productModelServices.getProductById(Integer.parseInt(product_id)).get();
			cart = userModelServices.getUserById(user_id).get().getCart();
			return addProduct(product, cart, Integer.parseInt(Quantity));
		}
		catch(Exception e){
			System.out.println("No product or user found for given id");
			return false;
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
	

