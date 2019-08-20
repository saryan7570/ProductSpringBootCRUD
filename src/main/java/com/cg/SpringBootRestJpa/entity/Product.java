package com.cg.SpringBootRestJpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Product {
	
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", initialValue = 50, sequenceName = "id_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

//	@Id
//	private int id;
	@Column
	private String name;
	@Column
	private String model;
	@Column
	private int quantity;
	@Column
	private int total;
	
	@Min(5000)
	@Max(50000)
	private int price;
	
	
	public Product() {
		super();
	}

	public Product(int id, String name, String model, int quantity, int total, @Min(5000) @Max(50000) int price) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.quantity = quantity;
		this.total = total;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", model=" + model + ", price=" + price + "]";
	}

}
