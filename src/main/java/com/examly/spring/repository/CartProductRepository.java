package com.examly.spring.repository;

import com.examly.spring.model.CartProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProductModel,Integer> {
}
