package com.backend.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Dto.CategoryDto;
import com.backend.Dto.ProductDto;
import com.backend.Exception.ResourceNotFoundException;
import com.backend.Model.Category;
import com.backend.Model.Product;
import com.backend.Repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;

	public CategoryDto createCategory(CategoryDto category) {
		//to cato
		Category entity=toEntity(category);
		Category save = categoryRepo.save(entity);
		
		//to cat
		CategoryDto dto=toDto(save);

		return dto;
	}

	public List<CategoryDto> viewAll() {
		List<Category> findAll = categoryRepo.findAll();
		List<CategoryDto> findAllDto= findAll.stream().map(category ->this.toDto(category)).collect(Collectors.toList());
		return findAllDto;
	}
	public CategoryDto viewCategoryById(int cid) {
		Category findById = categoryRepo.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException(+cid + "category not found"));
		CategoryDto dto=this.toDto(findById);
		return dto;
	}
	
	public void Deletecategory(int cid) {
		Category byId=categoryRepo.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException(+cid + "category not found"));
		categoryRepo.deleteById(cid);			
		
	}
	public CategoryDto updatecategory(int cid, CategoryDto newcategory) {
		Category oldcategory = categoryRepo.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException(+cid +" "+ "category not found"));
		oldcategory.setTitle(newcategory.getTitle());
		Category save=categoryRepo.save(oldcategory);
		CategoryDto dto=toDto(save);
		return dto;
	}
	
	//dto to category
	//public Product toEntity(ProductDto pDto)
	public Category toEntity(CategoryDto cDto) {
		Category c=new Category();
		c.setCategory_id(cDto.getCategory_id());
		c.setTitle(cDto.getTitle());
		return c;
	}
	
	public CategoryDto toDto(Category cat) {
		CategoryDto cd=new CategoryDto();
		cd.setCategory_id(cat.getCategory_id());
		cd.setTitle(cat.getTitle());
		return cd;
	}
	
	
	
	
	
	
	
	
}
