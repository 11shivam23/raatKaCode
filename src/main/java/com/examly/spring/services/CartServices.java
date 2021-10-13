package com.examly.spring.services;

import java.util.ArrayList;
import java.util.List;

import com.examly.spring.model.CartProductModel;
import com.examly.spring.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.CartModel;
import com.examly.spring.repository.CartRepository;

@Service
public class CartServices {
	
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	ProductServices productServices;

	@Autowired
	private UserServices userServices;

	@Autowired
	private CartProductServices cartProductServices;

	public boolean addProduct(ProductModel product, CartModel cart, int Quantity){
		if(Integer.parseInt(product.getQuantity()) >= Quantity){
			cart.setPrice(String.valueOf(Integer.parseInt(cart.getPrice()) + Integer.parseInt(product.getPrice())*Quantity));
			cart.setQuantity(cart.getQuantity()+Quantity);

			CartProductModel cartProductModel;
			if(!cartProductServices.existsProductCart(product,cart)){
				cartProductModel= new CartProductModel();
				cartProductModel.setProduct(product);
				cartProductModel.setCart(cart);
				cartProductModel.setQuantity(Quantity);
			}
			else{
				cartProductModel = cartProductServices.findByProductCart(product,cart);
				cartProductModel.setQuantity(cartProductModel.getQuantity()+Quantity);
			}
			cartProductServices.saveCartProduct(cartProductModel);

			cartRepository.save(cart);
			return true;
		}
		else
			return false;
	}

	public boolean addProduct(String product_id,String Quantity, int user_id){
		ProductModel product;
		CartModel cart;

		try {
			product = productServices.getProductById(Integer.parseInt(product_id)).get();
			cart = userServices.getUserById(user_id).get().getCart();
			return addProduct(product, cart, Integer.parseInt(Quantity));
		}
		catch(Exception e){
			System.out.println("No product or user found for given id"+e);
			return false;
		}
	}


	public List<CartProductModel> getCartItems(int userId) {

		CartModel cartModel = userServices.getUserById(userId).get().getCart();
		List<CartProductModel> cart = cartProductServices.findByCartId(cartModel);
		System.out.println("\n\n\n\n" + cart.size() + "\n\n\n\n");
		return cartProductServices.findByCartId(cartModel);
	}

	public void deleteItem(int cartItemId) {
		cartRepository.deleteById(cartItemId);
		
	}
}
	

