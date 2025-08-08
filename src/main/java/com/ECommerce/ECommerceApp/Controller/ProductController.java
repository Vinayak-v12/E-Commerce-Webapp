package com.ECommerce.ECommerceApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce.ECommerceApp.Dto.ResponseStructure;
import com.ECommerce.ECommerceApp.Entity.Product;
import com.ECommerce.ECommerceApp.Service.ProductService;
@RequestMapping("/admin")
@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/saveinfo")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product){
		return service.saveProduct(product);
	}
	

}
