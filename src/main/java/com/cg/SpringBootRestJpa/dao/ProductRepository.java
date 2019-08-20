package com.cg.SpringBootRestJpa.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.SpringBootRestJpa.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	 
	@Query("from Product where id= :c")
	Optional<Product> findById(@Param("c") int id);
	
//	@Query("from Product where id= :c")
//	void deleteById(@Param("c") int id);
	
}