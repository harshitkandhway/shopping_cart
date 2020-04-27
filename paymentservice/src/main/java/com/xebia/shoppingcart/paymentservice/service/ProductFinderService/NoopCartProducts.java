package com.xebia.shoppingcart.paymentservice.service.ProductFinderService;

import com.xebia.shoppingcart.paymentservice.representaion.ProductResponse;
import org.springframework.context.annotation.Profile;

@Profile("test")
public class NoopCartProducts implements ProductFinder{
    @Override
    public ProductResponse[] getAllProduct() {
        return null;
    }
}
