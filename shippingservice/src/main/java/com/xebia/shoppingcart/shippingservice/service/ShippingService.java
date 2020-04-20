package com.xebia.shoppingcart.shippingservice.service;

import com.xebia.shoppingcart.shippingservice.repository.ShippingRepository;
import com.xebia.shoppingcart.shippingservice.representation.ShippingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    public ShippingRequest saveShippingAddress(ShippingRequest shippingRequest) {
        return shippingRepository.save(shippingRequest);
    }
}
