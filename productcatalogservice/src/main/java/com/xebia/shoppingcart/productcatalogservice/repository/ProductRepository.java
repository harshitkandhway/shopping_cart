package com.xebia.shoppingcart.productcatalogservice.src.main.java.com.xebia.shoppingcart.productcatalogservice.repository;

import com.xebia.shoppingcart.productcatalogservice.src.main.java.com.xebia.shoppingcart.productcatalogservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
