package com.cg.SpringBootRestJpa.service;

import java.util.List;

import com.cg.SpringBootRestJpa.entity.Product;
import com.cg.SpringBootRestJpa.exception.CustomException;

public interface ProductService {

	public List<Product> addProduct(Product product) throws CustomException;
	public Product getProductById(int id) throws CustomException;
	public void deleteProduct(int id) throws CustomException;
	public List<Product> getAllProducts() throws CustomException;
	public List<Product> updateProduct(int id, Product product) throws CustomException;
	
}
