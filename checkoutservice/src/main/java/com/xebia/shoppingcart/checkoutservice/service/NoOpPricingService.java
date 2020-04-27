package com.xebia.shoppingcart.checkoutservice.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class NoOpPricingService implements Pricing {
    @Override
    public double getTotalPrice() {
        return 100;
    }
}
