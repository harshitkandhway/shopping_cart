package com.xebia.shoppingcart.productcatalogservice.service;

import com.xebia.shoppingcart.productcatalogservice.domain.Product;
import com.xebia.shoppingcart.productcatalogservice.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductCatalogServiceTest {
    @InjectMocks
    private ProductCatalogService productCatalogService;

    @Mock
    private ProductRepository productRepository;

    @Test
     void should_listAll_products() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(new Product()));
        List<Product> products = productCatalogService.listAll();
        Assertions.assertNotNull(products);
    }


}