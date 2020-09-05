package com.training.ms.cart.event.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerCart {
	
	
		 @Autowired
		 private KafkaTemplate<String, String> template;
		
		     public void produce(String message) {
		         template.send("PAYMENT_SUCCESSFULL", message);
		     }
	

}
