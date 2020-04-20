package com.xebia.shoppingcart.paymentservice.representaion;

import com.sun.tools.javac.util.List;

public class CartResponse {
    private List<ProductResponse> productResponses;

    public List<ProductResponse> getProductResponses() {
        return productResponses;
    }
}
