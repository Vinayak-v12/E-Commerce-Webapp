package com.ECommerce.ECommerceApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ECommerce.ECommerceApp.Entity.Orders;
import com.ECommerce.ECommerceApp.Repository.OrderRepository;
@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	public void save(Orders order) {
		repository.save(order);
	}
	public List<Orders> getAllOrders(Integer id){
		return repository.getAllOrders(id);
	}

}
