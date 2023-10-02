package com.backend.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Dto.CategoryDto;
import com.backend.Dto.ProductDto;
import com.backend.Exception.ResourceNotFoundException;
import com.backend.Model.Category;
import com.backend.Model.Product;
import com.backend.Repository.CategoryRepository;
import com.backend.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository catRepo;

	public ProductDto createProduct(ProductDto productDto, int catid) {
		// fetching category if there or not
		Category cat = this.catRepo.findById(catid)
				.orElseThrow(() -> new ResourceNotFoundException("category not found"));

		// product dto to product
		System.out.println(productDto.getProduct_name());
		Product product = toEntity(productDto);

		product.setCategory(cat);
		Product save = this.productRepo.save(product);
		// Product save = productRepo.save(entity);
		// product to dto
		ProductDto dto = toDto(save);

		return dto;
	}

	public List<ProductDto> viewAll() {
		List<Product> findAll = productRepo.findAll();
		List<ProductDto> findAllDto = findAll.stream().map(product -> this.toDto(product)).collect(Collectors.toList());
		findAllDto.stream().forEach(p -> System.out.println(p.getCategory()));
		return findAllDto;
	}

	public ProductDto viewProductById(int pid) {
		Product findById = productRepo.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException(+pid + "product not found"));
		System.out.println(" Enitity class " + findById.getCategory().getTitle());

		ProductDto dto = this.toDto(findById);
		// System.out.println("Dto class " +dto.getCategory().getTitle());
		return dto;
	}

	public void deleteProduct(int pid) {
		Product byId = productRepo.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException(+pid + "product not found"));
		productRepo.deleteById(pid);
	}

	public ProductDto updateProduct(int pid, ProductDto newproduct) {
		Product oldproduct = productRepo.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException(+pid + " " + "product not found"));
		oldproduct.setProduct_name(newproduct.getProduct_name());
		oldproduct.setProduct_prize(newproduct.getProduct_prize());
		oldproduct.setProduct_desc(newproduct.getProduct_desc());
		oldproduct.setProduct_imageName(newproduct.getProduct_imageName());
		oldproduct.setProduct_quantity(newproduct.getProduct_quantity());
		Product save = productRepo.save(oldproduct);
		ProductDto dto = toDto(save);
		return dto;
	}

	// DTO TO product
	public Product toEntity(ProductDto pDto) {
		Product p = new Product();

		p.setProduct_id(pDto.getProduct_id());
		p.setProduct_name(pDto.getProduct_name());
		p.setProduct_desc(pDto.getProduct_desc());
		p.setProduct_prize(pDto.getProduct_prize());
		p.setProduct_quantity(pDto.getProduct_quantity());
		p.setProduct_imageName(pDto.getProduct_imageName());
		
		return p;
	}

	// pro to productDto
	public ProductDto toDto(Product product) {
		ProductDto pdto = new ProductDto();
		pdto.setProduct_id(product.getProduct_id());
		pdto.setProduct_name(product.getProduct_name());
		pdto.setProduct_desc(product.getProduct_desc());
		pdto.setProduct_prize(product.getProduct_prize());
		pdto.setProduct_quantity(product.getProduct_quantity());
		pdto.setProduct_imageName(product.getProduct_imageName());

		// Change Category to CatDto
		CategoryDto catDto = new CategoryDto();
		catDto.setCategory_id(product.getCategory().getCategory_id());

		catDto.setTitle(product.getCategory().getTitle());
		// then catdto in prodto
		pdto.setCategory(catDto);
		//System.out.println("*******===========================================");
		//System.out.println(pdto.getCategory().getCategory_id());
		//System.out.println(pdto.getCategory().getTitle());
		//System.out.println(catDto.getCategory_id());
		//System.out.println(pdto.getCategory());
		
		//System.out.println(catDto.getTitle());
		//System.out.println("************************");
		
		return pdto;
	}

}
