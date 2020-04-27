package com.xebia.shoppingcart.cartservice.service;

import com.xebia.shoppingcart.cartservice.representation.ProductResponse;
import com.xebia.shoppingcart.cartservice.service.productfinder.ProductCatalogFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class CartService {

    @Autowired
    private ProductCatalogFinder productCatalogService;

    private RestTemplate restTemplate = new RestTemplate();

    //In memory storage which should be changed to caching.
    private Map<Integer, ProductResponse> cart = new HashMap();

    public Map<Integer, ProductResponse> getCart() {
        return cart;
    }

    public void addToCart(int id) {
        cart.put(id, productCatalogService.getProductResponse(id));
    }

    public boolean deleteFromCart(int id) {
        if (cart.containsKey(id)) {
            cart.remove(id);
            return true;
        }
        return false;
    }

    public List<ProductResponse> listAll() {
        return new ArrayList<>(cart.values());
    }

    public void removeAll() {
        cart.clear();
        //Stream.of(cart).forEach(i -> cart.remove(i));
    }
}
