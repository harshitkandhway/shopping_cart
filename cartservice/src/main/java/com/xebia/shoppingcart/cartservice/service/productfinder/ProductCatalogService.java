package com.xebia.shoppingcart.cartservice.service.productfinder;

import com.xebia.shoppingcart.cartservice.exception.ProductCatalogException;
import com.xebia.shoppingcart.cartservice.representation.ProductResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;

@Service
@Profile("!test")
public class ProductCatalogService implements ProductCatalogFinder {
    private RestTemplate restTemplate = new RestTemplate();

    public ProductResponse getProductResponse(int id) {
        ProductResponse productToAdd = restTemplate.getForObject(
                "http://localhost:8081/shoppingcart/products/{id}",
                ProductResponse.class,id);
        if (Objects.isNull(productToAdd)) {
            throw new ProductCatalogException("No response from ProductCatalog for id : "+id);
        }
        return productToAdd;
    }
}