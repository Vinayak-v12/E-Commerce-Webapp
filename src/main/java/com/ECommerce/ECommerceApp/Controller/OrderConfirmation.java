package com.ECommerce.ECommerceApp.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.ECommerce.ECommerceApp.Entity.Orders;
import com.ECommerce.ECommerceApp.Entity.Product;
import com.ECommerce.ECommerceApp.Entity.Users;
import com.ECommerce.ECommerceApp.Service.OrderService;
import com.ECommerce.ECommerceApp.Service.ProductService;
import com.ECommerce.ECommerceApp.Service.UserService;

@Controller
public class OrderConfirmation {
	@Autowired
	private UserService userservice;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	


	    @PostMapping("/buy/{id}")
	    public String confirmOrder(@PathVariable int id, Model model) {
	        Product product = productService.getProductById(id);
	        model.addAttribute("product", product);
	        return "confirmOrder"; // this will be confirm_order.html
	    }
	    
	    @PostMapping("/place-order/{id}")
	   public String placeOrder(@PathVariable int id) {
	    	String username = SecurityContextHolder.getContext().getAuthentication().getName();

	    	Users user= userservice.findByUsername(username);
	 	    Product product = productService.getProductById(id);
	 	    	if (product.getStock_Qty_Available() > 0) {
	 	    		Orders order = new Orders();
	 	            order.setUser(user);
	 	            order.setProduct(product);
	 	            order.setStatus("On Transit");
	 	            order.setOrderDate(LocalDateTime.now());
	 	            order.setDeliveryDate(order.getOrderDate().plusDays((int)(Math.random()*10)));
	 	            product.setStock_Qty_Available(product.getStock_Qty_Available()-1);
	 	            productService.save(product);
	 	            orderService.save(order);
	 	           return "OnOrderSuccess"; 
	 	        }
	 	    	else {
	 	    		return "outOfStock";
	 	    	}
	 	    		
	 	  
	    }
	}



