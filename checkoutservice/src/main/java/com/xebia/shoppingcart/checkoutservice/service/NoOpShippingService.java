package com.xebia.shoppingcart.checkoutservice.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class NoOpShippingService implements Shipping {
    @Override
    public String getShippingId() {
        return "default_shipping_Id";
    }
}
