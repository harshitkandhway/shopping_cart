package com.xebia.shoppingcart.checkoutservice.service;

import com.xebia.shoppingcart.checkoutservice.exception.PricingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
@FeignClient(name ="pricingservice-feign", url = "http://localhost:8082/shoppingcart/")
public interface PricingService{
    @RequestMapping(value ="payment" , method = RequestMethod.GET)
    public double getTotalPrice();
}

/*@Service
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
}*/
