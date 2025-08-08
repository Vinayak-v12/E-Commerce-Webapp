package com.ECommerce.ECommerceApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ECommerce.ECommerceApp.Entity.Users;
import com.ECommerce.ECommerceApp.Repository.UserRepository;

import jakarta.persistence.NoResultException;
@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	public Users findByUsername(String username){
		 Optional<Users> opt=repository.findByUsername(username);
		 if(opt.isPresent()) {
			 Users user =opt.get();
			 return user;
		 }
		 else {
			 throw new NoResultException();
		 }
	}
	public Integer getIdByUserName(String username) {
		return repository.getIdByUserName(username);
	}

}
