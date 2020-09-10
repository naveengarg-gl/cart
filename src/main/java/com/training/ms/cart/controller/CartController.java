package com.training.ms.cart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.ms.cart.event.producer.ProducerCart;
import com.training.ms.cart.model.CartDetail;
import com.training.ms.cart.repo.CartRepository;



@RefreshScope
@RestController
public class CartController {
	
	@Autowired
	CartRepository cartRepository;
	
	@Value("${cart.name}")
    private String name;
	
	@Autowired
	ProducerCart producerCart;
	
	 @Autowired
	  private Environment environment;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @PostMapping("/cart-service/customer/{customerId}")
	  public CartDetail addProductToCart
	    (@PathVariable Long customerId,@RequestBody CartDetail cartDetail){
		 CartDetail existingCartDetail = cartRepository.findByCustomerId(cartDetail.getCustomerId());
		 if(existingCartDetail != null)
		 {
			 cartDetail.setTotalCartValue(existingCartDetail.getTotalCartValue()+cartDetail.getPrice());
		 }
		 else
		 {
			 cartDetail.setTotalCartValue(cartDetail.getPrice());
		 }
		 cartRepository.save(cartDetail);
	    return cartDetail;
	  
	}
	 
	 
	 @GetMapping("/cart-service/customer/{customerId}")
	  public CartDetail getCartDetail
	    (@PathVariable int customerId){
		 logger.info("Cart Service Port="+Integer.parseInt(environment.getProperty("local.server.port")));
		 CartDetail cartDetail = cartRepository.findByCustomerId(customerId);
		 if(cartDetail==null)
		 {
			 cartDetail = new CartDetail();
		 }
		 cartDetail.setProductName(name);
	    return cartDetail;
	  
	} 
	 
	 @PostMapping("/cart-service/customer/{customerId}/checkout")
	  public Integer checkoutCustomer
	    (@PathVariable int customerId){
		 producerCart.produce("Payment Suceesful for customer id="+customerId);
		 
	    return customerId;
	  
	} 


}
