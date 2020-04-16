package com.xebia.shoppingcart.cartservice.service.productfinder;

import com.xebia.shoppingcart.cartservice.representation.ProductResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class NoopProductCatalogService implements ProductCatalogFinder {
    public ProductResponse getProductResponse(int id) {
        return new ProductResponse();
    }
}
