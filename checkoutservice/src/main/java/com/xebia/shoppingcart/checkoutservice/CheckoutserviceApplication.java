package com.xebia.shoppingcart.checkoutservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CheckoutserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutserviceApplication.class, args);
	}

}
