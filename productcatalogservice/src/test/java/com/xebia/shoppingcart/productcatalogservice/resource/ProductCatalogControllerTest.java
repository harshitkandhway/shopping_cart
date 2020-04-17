package com.xebia.shoppingcart.productcatalogservice.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xebia.shoppingcart.productcatalogservice.domain.Product;
import com.xebia.shoppingcart.productcatalogservice.enumeration.Categories;
import com.xebia.shoppingcart.productcatalogservice.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductCatalogControllerTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        Product p1 = new Product.Builder().withName("Camera")
                .withDescription("Antique Camera was manufactured on 1919")
                .withCategory(Categories.VINTAGE)
                .withPicture("Unavailable")
                .withPrice(50000.00).build();
        Product p2 = new Product.Builder().withName("Pen")
                .withDescription("Blue Pen manufactured by Parker")
                .withCategory(Categories.STATIONARY)
                .withPicture("Unavailable")
                .withPrice(700.00).build();
        Product p3 = new Product.Builder().withName("Flying Saucer")
                .withDescription("Manufacture by NASA")
                .withCategory(Categories.VINTAGE)
                .withPicture("Unavailable")
                .withPrice(2500000.00).build();
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

    }

    @Test
    void should_get_all_products() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/shoppingcart/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].name").value("Camera"))
                .andExpect(jsonPath("$[1].name").value("Pen"));

    }

}
