package com.xebia.shoppingcart.productcatalogservice.src.main.java.com.xebia.shoppingcart.productcatalogservice.service;

import com.xebia.shoppingcart.productcatalogservice.src.main.java.com.xebia.shoppingcart.productcatalogservice.domain.Product;
import com.xebia.shoppingcart.productcatalogservice.src.main.java.com.xebia.shoppingcart.productcatalogservice.enumeration.Categories;
import com.xebia.shoppingcart.productcatalogservice.src.main.java.com.xebia.shoppingcart.productcatalogservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductCatalogService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> listAll() {
       return productRepository.findAll();
    }

    public Optional<Product> getById(int id) {
        return productRepository.findById(id);
    }
}
