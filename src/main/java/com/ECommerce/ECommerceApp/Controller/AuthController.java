package com.ECommerce.ECommerceApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ECommerce.ECommerceApp.Entity.Users;
import com.ECommerce.ECommerceApp.Repository.UserRepository;

@Controller
public class AuthController {

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @GetMapping("/vinayak.com")
	    public String showRegisterForm() {
	        return "register";
	    }

	    @PostMapping("/register")
	    public String processRegister(@RequestParam String username,@RequestParam String password ) {
	    	Users user=new Users();
	    	user.setUsername(username);
	        user.setPassword(passwordEncoder.encode(password));
	        userRepository.save(user);
	        return "redirect:/login";
	    }

	    @GetMapping("/login")
	    public String showLoginPage() {
	        return "login";
	    }
	}



