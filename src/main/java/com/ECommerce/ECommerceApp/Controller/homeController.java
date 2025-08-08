package com.ECommerce.ECommerceApp.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ECommerce.ECommerceApp.Config.CustomUserDetails;
import com.ECommerce.ECommerceApp.Entity.Orders;
import com.ECommerce.ECommerceApp.Entity.Product;
import com.ECommerce.ECommerceApp.Service.OrderService;
import com.ECommerce.ECommerceApp.Service.ProductService;
import com.ECommerce.ECommerceApp.Service.UserService;
@Controller
public class homeController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/home")
	public String home(Model model) {
		 List<Product> products=productService.getAllProducts();
		 model.addAttribute("Products", products);
		 return "home";
	}
	@PostMapping("/findProduct")
	public String home(@RequestParam String name,Model model) {
		Product product=productService.getProductByName(name);
		model.addAttribute("product", product);
		return "searchOrder";
	}
	@GetMapping("/profile")
	public String userProfile(Model model) {
	        // Get authentication from security context
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    	if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
	            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

	            // Pass user details to the view
	            model.addAttribute("username", userDetails.getUsername());
	          //  model.addAttribute("email", userDetails.getEmail()); // if available
	            model.addAttribute("roles", userDetails.getAuthorities());
	        } else {
	            model.addAttribute("error", "User not authenticated");
	        }

	        return "profile";
	}
	@GetMapping("/My Orders")
	public String orderDetails(Model model) {
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		Integer userid=userService.getIdByUserName(username);
		List<Orders> orders=orderService.getAllOrders(userid);
		model.addAttribute("Orders", orders);
		return "OrderDetails";
		
	}
	

	 
	 
}
