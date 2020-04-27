package com.xebia.shoppingcart.checkoutservice.service;

import com.xebia.shoppingcart.checkoutservice.exception.PricingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@Profile("!test")
public class PricingService implements Pricing{

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public double getTotalPrice() {
        Double totalPrice = restTemplate.getForObject("http://localhost:8082/shoppingcart/payment", Double.class);
        if(Objects.nonNull(totalPrice))
            return totalPrice;
        throw new PricingException("response from paymentservice module not received");
    }
}
