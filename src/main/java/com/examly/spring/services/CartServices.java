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
//			if(!cartProductServices.existsProduct(product) && !cartProductServices.existsCart(cart)) {
			if(!cartProductServices.existsProductCart(product,cart)){
				cartProductModel= new CartProductModel();
				cartProductModel.setProduct(product);
				cartProductModel.setCart(cart);
				cartProductModel.setQuantity(Quantity);
				cartProductModel.setPrice(product.getPrice());
				cartProductModel.setProductName(product.getProductName());
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

		CartModel cartModel = cartRepository.findByUser(userId);
		int cartId = cartModel.getCartId();

		List<CartProductModel> cartProductModel = new ArrayList<>();
//		cartProductServices.findByCartId(cartId).forEach(cartProductModel::add);
		return cartProductModel;
	}

	public void deleteItem(Integer cartItemId) {
		cartRepository.deleteById(cartItemId);
		
	}
}
	

