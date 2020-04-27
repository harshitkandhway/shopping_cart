package com.xebia.shoppingcart.paymentservice.service.ProductFinderService;

import com.xebia.shoppingcart.paymentservice.representaion.ProductResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("!test")
public class CartProducts implements ProductFinder {
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public ProductResponse[] getAllProduct() {
        ProductResponse[] productToAdd = restTemplate.getForObject(
                "http://localhost:8081/shoppingcart/cart",
                ProductResponse[].class);
               return productToAdd;
    }
}
