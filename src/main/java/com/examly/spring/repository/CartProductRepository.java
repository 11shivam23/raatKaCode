package com.examly.spring.repository;

import com.examly.spring.model.CartModel;
import com.examly.spring.model.CartProductModel;
import com.examly.spring.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProductModel,Integer> {
    
    boolean existsByProduct(ProductModel product);

    boolean existsByCart(CartModel cart);

    CartProductModel findByProductAndCart(ProductModel product, CartModel cart);
}
