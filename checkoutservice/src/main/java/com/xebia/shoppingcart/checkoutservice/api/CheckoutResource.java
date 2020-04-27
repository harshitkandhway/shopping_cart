package com.xebia.shoppingcart.checkoutservice.api;

import com.xebia.shoppingcart.checkoutservice.representation.CheckoutResponse;
import com.xebia.shoppingcart.checkoutservice.service.Pricing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CheckoutResource {

    @Autowired
    private Pricing pricing;

    //get call from pricing-
    //post call for paymrnt 'details'
    //post order confirmation shipping id & order confirmation id
    //get call from shipping for order comfirmation details
    @GetMapping
    public ResponseEntity<CheckoutResponse> getCheckoutDetails(){
        double totalPrice = pricing.getTotalPrice();
        CheckoutResponse response = new CheckoutResponse(UUID.randomUUID().toString(),UUID.randomUUID().toString(),totalPrice);
        return ResponseEntity.ok().body(response);
    }


}
