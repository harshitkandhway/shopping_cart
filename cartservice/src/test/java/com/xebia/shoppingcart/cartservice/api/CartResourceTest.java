package com.xebia.shoppingcart.cartservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xebia.shoppingcart.cartservice.representation.ProductResponse;
import com.xebia.shoppingcart.cartservice.service.CartService;
import com.xebia.shoppingcart.cartservice.service.productfinder.ProductCatalogFinder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CartResourceTest {

    @Autowired
    private ProductCatalogFinder productCatalogFinder;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CartService cartService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_add_product_to_cart() throws Exception {
        int id = 1;
        ProductResponse productResponse = productCatalogFinder.getProductResponse(id);
        String json = objectMapper.writeValueAsString(productResponse);
        mockMvc.perform(post("/shoppingcart/cart/{id}",id)
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print()).andExpect(status().isOk());
         Assertions.assertThat(cartService.getCart().containsKey(1)).isTrue();
    }

//    @Test
//    void deleteFromCart() {
//
//    }
//
//    @Test
//    void getAllItems() {
//    }
//
//    @Test
//    void emptyCart() {
//    }
}