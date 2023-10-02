package com.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	//public Product findById(int product);
}
