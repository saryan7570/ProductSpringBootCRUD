package com.cg.SpringBootRestJpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.SpringBootRestJpa.dao.ProductRepository;
import com.cg.SpringBootRestJpa.entity.Product;
import com.cg.SpringBootRestJpa.exception.CustomException;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> addProduct(Product product) throws CustomException {
		try {
			product.setTotal(product.getPrice() * product.getQuantity());
			productRepository.save(product);
			return productRepository.findAll();
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public Product getProductById(int id) throws CustomException {
		try {
			return productRepository.findById(id).get();
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> updateProduct(int id, Product product) {
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product product1 = optional.get();
			product1.setName(product.getName());
			product1.setModel(product.getModel());
			product1.setPrice(product.getPrice());
			productRepository.save(product1);
			return getAllProducts();
		}
		else{
			System.out.println("Customer with ID " +id+ " does not exist");
			return null;
		}
	}

}
