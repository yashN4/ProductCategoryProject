package com.backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.backend.Dto.ProductDto;
import com.backend.Model.Product;
import com.backend.Service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	// to get JSON OBJ//
	@Autowired
	private ProductService productService;

	@PostMapping("/products/{catid}")
	@ResponseBody // CREATE PRODUCT use (product/categoryID) to assign categories to product directly //
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product,@PathVariable int catid) {
		ProductDto createProduct = productService.createProduct(product,catid);
		return new ResponseEntity<ProductDto>(createProduct,HttpStatus.CREATED);
	}

	// view all product//
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> viewAllProduct(@RequestParam(name="page",defaultValue = "1")int page) {
		if(page==2) {
			List<ProductDto> viewAll = productService.viewAll();
			return new ResponseEntity<List<ProductDto>>(viewAll,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<List<ProductDto>>(HttpStatus.NOT_FOUND);
		}
		
	}

	// get product by id//
	@GetMapping("products/{product_id}")
	public ResponseEntity<ProductDto> viewProductById(@PathVariable int product_id) {
		ProductDto viewProductById = productService.viewProductById(product_id);
		
		return new ResponseEntity<ProductDto>(viewProductById,HttpStatus.OK);
	}

	// delete product by id//
	@DeleteMapping("products/{product_id}")
	public ResponseEntity<String>deleteProduct(@PathVariable int product_id) {
		productService.deleteProduct(product_id);
		return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
	}

	// update product by id//
	@PutMapping("products/{product_id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable int product_id,@RequestBody ProductDto newproduct) {
		ProductDto updateProduct = productService.updateProduct(product_id,newproduct);
		return new ResponseEntity<ProductDto>(updateProduct,HttpStatus.ACCEPTED);
	}

}
