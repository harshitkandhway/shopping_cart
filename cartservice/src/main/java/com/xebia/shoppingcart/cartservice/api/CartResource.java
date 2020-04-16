package com.xebia.shoppingcart.cartservice.api;

import com.xebia.shoppingcart.cartservice.representation.ProductResponse;
import com.xebia.shoppingcart.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart/cart")
public class CartResource {

    @Autowired
    private CartService cartService;

    @PostMapping("/{id}")
    public ResponseEntity<Void> addProductToCart(@PathVariable("id") Integer id) {
        cartService.addToCart(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFromCart(@PathVariable("id") int id) {
        boolean isDeleted = cartService.deleteFromCart(id);
        if (isDeleted)
            return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllItems() {
        List<ProductResponse> productResponses = cartService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(productResponses);
    }

    @DeleteMapping
    public ResponseEntity<Void> emptyCart() {
        cartService.removeAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
