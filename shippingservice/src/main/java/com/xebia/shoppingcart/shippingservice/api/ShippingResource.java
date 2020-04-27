package com.xebia.shoppingcart.shippingservice.api;

import com.xebia.shoppingcart.shippingservice.representation.ShippingRequest;
import com.xebia.shoppingcart.shippingservice.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shoppingcart/shipping")
public class ShippingResource {
    @Autowired
    private ShippingService shippingService;

    @PostMapping
    public ResponseEntity<ShippingRequest> addShippingInfo(@RequestBody ShippingRequest shippingRequest) {
        ShippingRequest savedDetails = shippingService.saveShippingAddress(shippingRequest);
        //if (Objects.nonNull(savedDetails))
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDetails);
    }

//    @GetMapping-- not required for now
//    public ResponseEntity<ShippingRequest> getShippingDetails(){
//
//    }

}
