package com.examly.spring.repository;

import com.examly.spring.model.CartModel;

//import java.util.List;

import com.examly.spring.model.ProductModel;
import com.examly.spring.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<CartModel,Integer>{

	CartModel getCartByUser(UserModel user);

	void deleteById(Integer cart_item_id);

	CartModel findByUser(int userId);


//	public List<CartModel> getCartModelByUserId(int userId);
}
