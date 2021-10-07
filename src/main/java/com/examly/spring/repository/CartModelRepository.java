package com.examly.spring.repository;

import com.examly.spring.model.CartModel;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartModelRepository extends JpaRepository<CartModel,String>{

	void deleteById(String cartItemId);
	
//	public List<CartModel> getCartModelByUserId(int userId);
}
