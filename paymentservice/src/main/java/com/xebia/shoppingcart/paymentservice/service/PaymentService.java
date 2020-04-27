package com.xebia.shoppingcart.paymentservice.service;

import com.xebia.shoppingcart.paymentservice.model.CardDetails;
import com.xebia.shoppingcart.paymentservice.representaion.ProductResponse;
import com.xebia.shoppingcart.paymentservice.service.ProductFinderService.ProductFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PaymentService {
    private CardDetails savedDetails;

    @Value("${shipping.charges}")
    private double shippingCharges;

    @Autowired
    private ProductFinder productFinder;

    public double getTotalAmount() {
        ProductResponse[] productResponses = productFinder.getAllProduct();
        //double sum = productResponses.stream().mapToDouble(ProductResponse::getPrice).sum();
        double sum = Arrays.stream(productResponses).mapToDouble(ProductResponse::getPrice).sum();
        return sum+shippingCharges;
    }

    public void saveCardDetails(CardDetails cardDetails) {
        savedDetails = cardDetails;
    }
}
