package com.examly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.spring.model.ProductModel;
import com.examly.spring.repository.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
    ProductRepository productRepository;

	public List<ProductModel> getAllProducts() {
		return productRepository.findAll();
	}

	public Optional<ProductModel> getProductById(int id) {
		return productRepository.findById(id);
	}

	public void editSave(ProductModel product, int id) {
		ProductModel pr = productRepository.findByProductId(id);
		pr.setDescription(product.getDescription());
		pr.setImageUrl(product.getImageUrl());
		pr.setPrice(product.getPrice());
		pr.setProductName(product.getProductName());
		productRepository.save(pr);
	}

	public boolean saveProduct(ProductModel product) {
		int productId = product.getProductId();
		if(!productRepository.existsByProductId(productId)) {
			productRepository.save(product);
			return true;
		}
		return false;
	}

	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
}