package com.xebia.shoppingcart.cartservice.service.productfinder;

import com.xebia.shoppingcart.cartservice.representation.ProductResponse;

public interface ProductCatalogFinder {
    public ProductResponse getProductResponse(int id);
}
