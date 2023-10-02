package com.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;

	private String product_name;
	private double product_prize;
	private double product_quantity;
	private String product_imageName;
	private String product_desc;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	public Product() {
		
	}
	public Product(int product_id, String product_name, double product_prize, int product_quantity,
		 String product_imageName, String product_desc) {
	
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_prize = product_prize;
		this.product_quantity = product_quantity;
		this.product_imageName = product_imageName;
		this.product_desc = product_desc;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_prize() {
		return product_prize;
	}
	public void setProduct_prize(double product_prize) {
		this.product_prize = product_prize;
	}

	public double getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(double product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getProduct_imageName() {
		return product_imageName;
	}
	public void setProduct_imageName(String product_imageName) {
		this.product_imageName = product_imageName;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	

	
	
	
}
