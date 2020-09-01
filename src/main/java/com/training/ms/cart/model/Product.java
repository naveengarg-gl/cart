package com.training.ms.cart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	int productId;
	String productName;
	String productDetails;
	Double price;

}
