package com.training.ms.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.ms.cart.model.CartDetail;


public interface CartRepository extends 
JpaRepository<CartDetail, Integer>{
	
	CartDetail findByCustomerId(int customerId);

}
