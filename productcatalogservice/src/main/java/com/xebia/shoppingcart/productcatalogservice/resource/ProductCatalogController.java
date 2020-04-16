package com.xebia.shoppingcart.productcatalogservice.src.main.java.com.xebia.shoppingcart.productcatalogservice.resource;

import com.xebia.shoppingcart.productcatalogservice.src.main.java.com.xebia.shoppingcart.productcatalogservice.domain.Product;
import com.xebia.shoppingcart.productcatalogservice.src.main.java.com.xebia.shoppingcart.productcatalogservice.enumeration.Categories;
import com.xebia.shoppingcart.productcatalogservice.src.main.java.com.xebia.shoppingcart.productcatalogservice.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/shoppingcart/products")
public class ProductCatalogController {
    @Autowired
    private ProductCatalogService productCatalogService;

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> products = productCatalogService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable("id") int id) {
        Optional<Product> found = productCatalogService.getById(id);
        System.out.println("----->"+found.get());
        if (found.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(found.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Product> addToProduct(@RequestBody Product productRequest){
        Product addedProduct = productCatalogService.addProduct(productRequest);
        return ResponseEntity.status(HttpStatus.OK).body(addedProduct);
    }
}
