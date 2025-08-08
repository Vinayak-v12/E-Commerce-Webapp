package com.ECommerce.ECommerceApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ECommerce.ECommerceApp.Dto.ResponseStructure;
import com.ECommerce.ECommerceApp.Entity.Product;
import com.ECommerce.ECommerceApp.Repository.ProductRepository;

import jakarta.persistence.NoResultException;
@Service
public class ProductService {
	@Autowired	
	private ProductRepository repository;
	
	public void save( Product product) {
		repository.save(product);
	}
	
	public List<Product> getAllProducts(){
		 List<Product> products=repository.findAll();
		 if(!products .isEmpty()) {
			 return products;
		 }
		 else {
			  throw new NoResultException("no record to display");
		 }
		
	}
	public Product getProductById(int id) {
		Optional<Product> opt=repository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new NoResultException("no record");
		}
	}
	public Product getProductByName(String name) {
		Optional<Product> opt=repository.getProductByName(name);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new NoResultException("no record found ");
		}
	}
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product){
		ResponseStructure<Product> response=new ResponseStructure<Product>();
		Product prod=repository.save(product);
		response.setData(prod);
		response.setMessage("saved product in Db");
		response.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(response,HttpStatus.CREATED);
		
	}


}
