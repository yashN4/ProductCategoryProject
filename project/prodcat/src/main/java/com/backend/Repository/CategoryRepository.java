package com.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
