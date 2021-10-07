package com.examly.spring.repository;

import com.examly.spring.model.CartModel;

//import java.util.List;

import com.examly.spring.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartModelRepository extends JpaRepository<CartModel,Integer>{

	CartModel getCartByUser(UserModel user);

	void deleteById(Integer cartItemId);
	
//	public List<CartModel> getCartModelByUserId(int userId);
}
