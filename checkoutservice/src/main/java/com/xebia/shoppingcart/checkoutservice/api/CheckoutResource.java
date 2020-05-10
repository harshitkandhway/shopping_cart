package com.xebia.shoppingcart.checkoutservice.api;

import com.xebia.shoppingcart.checkoutservice.representation.CheckoutResponse;
import com.xebia.shoppingcart.checkoutservice.service.Pricing;
import com.xebia.shoppingcart.checkoutservice.service.PricingService;
import com.xebia.shoppingcart.checkoutservice.service.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CheckoutResource {
    @Autowired
    PricingService pricingService;

    @Autowired
    private Pricing pricing;

    @Autowired
    private Shipping shipping;

    //get call from pricing-
    //post call for paymrnt 'details'
    //post order confirmation shipping id & order confirmation id
    //get call from shipping for order comfirmation details
    @GetMapping("/shoppingcart/checkout")
    public ResponseEntity<CheckoutResponse> getCheckoutDetails(){
       // double totalPrice = pricing.getTotalPrice();
        double totalPrice = pricingService.getTotalPrice();
        String shippingId = shipping.getShippingId();
        String trackingId = UUID.randomUUID().toString();
        CheckoutResponse response = new CheckoutResponse(trackingId,shippingId,totalPrice);
        return ResponseEntity.ok().body(response);
    }






}
