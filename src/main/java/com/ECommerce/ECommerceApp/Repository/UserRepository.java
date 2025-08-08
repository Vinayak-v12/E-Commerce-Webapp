package com.ECommerce.ECommerceApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ECommerce.ECommerceApp.Entity.Users;
@Repository
public interface UserRepository  extends JpaRepository<Users, Integer>{
	@Query("Select u from Users u where u.username=?1")
	Optional<Users> findByUsername(String username);
	@Query("select u.id from Users u where u.username=?1")
	Integer getIdByUserName(String username);

}
