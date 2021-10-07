package com.examly.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.examly.spring.model.ProductModel;

public interface ProductModelRepository extends JpaRepository<ProductModel,Integer>,CrudRepository<ProductModel,Integer> {

	boolean existsByProductId(String productId);

}
