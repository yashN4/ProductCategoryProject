package com.backend.Dto;

import com.backend.Model.Category;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class ProductDto {

	
	private int product_id;

	private String product_name;
	private double product_prize;
	private double product_quantity;
	private String product_imageName;
	private String product_desc;
	
	private CategoryDto category;

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

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	
	
	
}
