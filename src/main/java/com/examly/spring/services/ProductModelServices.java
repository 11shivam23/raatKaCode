package com.examly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.ProductModel;
import com.examly.spring.repository.ProductModelRepository;

@Service
public class ProductModelServices {
	
	@Autowired
	ProductModelRepository productModelRepository;

	public List<ProductModel> getAllProducts() {
		return productModelRepository.findAll();
	}

	public Optional<ProductModel> getProductById(int id) {
		return productModelRepository.findById(id);
	}

	public void editSave(ProductModel product) {
		productModelRepository.save(product);	
	}

	public boolean saveProduct(ProductModel product) {
		String productId = product.getProductId();
		if(!productModelRepository.existsByProductId(productId)) {
			productModelRepository.save(product);
			return true;
		}
		return false;
	}

	public void deleteProduct(int id) {
		productModelRepository.deleteById(id);
	}
}
