package com.training.ms.cart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartDetail {
	
	@Id
	int cartId;
	int customerId;
	int productId;
	String productName;
	String productDetails;
	Double price;
	Double totalCartValue;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotalCartValue() {
		return totalCartValue;
	}
	public void setTotalCartValue(Double totalCartValue) {
		this.totalCartValue = totalCartValue;
	}
	
	public CartDetail(int cartId, int customerId, int productId, String productName, String productDetails,
			Double price, Double totalCartValue) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.productId = productId;
		this.productName = productName;
		this.productDetails = productDetails;
		this.price = price;
		this.totalCartValue = totalCartValue;
	}
	public CartDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
