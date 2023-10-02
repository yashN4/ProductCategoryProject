package com.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Dto.CategoryDto;
import com.backend.Model.Category;
import com.backend.Service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	//Creating JSON OBJ
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/categories")
	@ResponseBody // CREATE PRODUCT //
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto category) {
		CategoryDto createCategory = categoryService.createCategory(category);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}

	// view all category//
	@GetMapping("/categories")
	public ResponseEntity<List<CategoryDto>> viewAllCategory(@RequestParam(name="page",defaultValue = "1")int page) {
		if(page==2) {
			List<CategoryDto> viewAll = categoryService.viewAll();
			return new ResponseEntity<List<CategoryDto>>(viewAll,HttpStatus.ACCEPTED);
		}else {
			List<CategoryDto> viewAll = categoryService.viewAll();
			return new ResponseEntity<List<CategoryDto>>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}

	// get category by id//
	@GetMapping("categories/{category_id}")
	public ResponseEntity<CategoryDto> viewCategoryById(@PathVariable int category_id) {
		CategoryDto viewCategoryById = categoryService.viewCategoryById(category_id);
		return new ResponseEntity<CategoryDto>(viewCategoryById,HttpStatus.OK);
	}

	// delete category by id//
	@DeleteMapping("categories/{category_id}")
	public ResponseEntity<String>deleteCategory(@PathVariable int category_id) {
		categoryService.Deletecategory(category_id);
		return new ResponseEntity<String>("Category Deleted",HttpStatus.OK);
	}

	// update category by id//
	@PutMapping("/categories/{category_id}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable int category_id,@RequestBody CategoryDto newcategory) {
		CategoryDto updateCategory = categoryService.updatecategory(category_id,newcategory);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.ACCEPTED);
	}

	
}
