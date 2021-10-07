package com.examly.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examly.spring.model.ProductModel;
import com.examly.spring.services.ProductModelServices;

@RestController
public class ProductController {
	
	@Autowired
	ProductModelServices productModelServices;
	
	@GetMapping(value="/admin")
	public List<ProductModel> getProduct(){
		return productModelServices.getAllProducts();
	}
	
	@GetMapping(value="/home")
	public List<ProductModel> getHomeProduct(){
		return productModelServices.getAllProducts();
	}
	
	@GetMapping(value="/admin/productEdit/{id}")
	public  Optional<ProductModel> productEditData(@PathVariable int id) {
		return productModelServices.getProductById(id);
	}
	
	@PutMapping(value="/admin/productEdit/{id}")
	public void productEditSave(@RequestBody ProductModel product, @PathVariable int id){
		productModelServices.editSave(product);
	}
	
	@PostMapping(value="/admin/addProduct")
	public boolean productSave(@RequestBody ProductModel product){
		return productModelServices.saveProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/admin/delete/{id}")
	public void productDelete(@PathVariable int id){
		productModelServices.deleteProduct(id);
	}
}
