package com.xebia.shoppingcart.checkoutservice.service;

import com.xebia.shoppingcart.checkoutservice.exception.ShippingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@Profile("!test")
public class ShippingService implements Shipping {

    private RestTemplate restTemplate= new RestTemplate();

    @Override
    public String getShippingId() {
        String shippingId = restTemplate.getForObject("http://localhost:8083/shoppingcart/shipping"
                , String.class);
        if(Objects.nonNull(shippingId))
            return shippingId;
        throw new ShippingException("Shipping Service not reachable...!");
    }
}
