package com.cg.SpringBootRestJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.SpringBootRestJpa.entity.Product;
import com.cg.SpringBootRestJpa.exception.CustomException;
import com.cg.SpringBootRestJpa.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/products")
	public List<Product> getAllproducts() throws CustomException{
		return productService.getAllProducts();
	}
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public List<Product> addProduct(@RequestBody Product product) throws CustomException{
		return productService.addProduct(product);
	}
	
	@RequestMapping(value="/product/{id}")
	public Product getProductById(@PathVariable int id) throws CustomException{
		return productService.getProductById(id);
	}
	
	@DeleteMapping(value="/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) throws CustomException{
		productService.deleteProduct(id);
		return new ResponseEntity<String> ("Book with ID " +id+ " deleted", HttpStatus.OK);
	}
	
	@PutMapping("/products/{id}")
	public List<Product> updateProduct(@PathVariable int id, @RequestBody Product product) throws CustomException{
		return productService.updateProduct(id, product);
	}
	
}
