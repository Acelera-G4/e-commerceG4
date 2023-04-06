package com.rafael.ProductApi.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael.ProductApi.domain.entity.Product;
import com.rafael.ProductApi.domain.service.ProductService;
import com.rafael.ProductApi.integration.endpoint.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProductControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    public void givenProductWhenCallGetProductsThenReturnProducts()
            throws Exception {
        Product product = Product.builder()
                .withProductId(1L)
                .withName("Product Test")
                .withDescription("Description Test")
                .withImage("image.png")
                .withPrice(9.99)
                .withIsActive(true)
                .build();

        given(productService.getProducts()).willReturn(Collections.singletonList(product));

        mvc.perform(MockMvcRequestBuilders.get("/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty());
    }

    @Test
    public void givenNoProductWhenCallGetProductsThenReturnEmptyList()
            throws Exception {
        given(productService.getProducts()).willReturn(Collections.emptyList());

        mvc.perform(MockMvcRequestBuilders.get("/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    public void givenProductWhenCallGetProductThenReturnProduct()
            throws Exception {
        Product product = Product.builder()
                .withProductId(1L)
                .withName("Product Test")
                .withDescription("Description Test")
                .withImage("image.png")
                .withPrice(9.99)
                .withIsActive(true)
                .build();

        given(productService.getProduct(any())).willReturn(product);

        mvc.perform(MockMvcRequestBuilders.get("/product/{id}",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").isNotEmpty());
    }

    @Test
    public void givenProductWhenCallPutProductThenUpdateProduct()
            throws Exception {
        Product product = Product.builder()
                .withProductId(1L)
                .withName("Product Test")
                .withDescription("Description Test")
                .withImage("image.png")
                .withPrice(9.99)
                .withIsActive(true)
                .build();

        mvc.perform(MockMvcRequestBuilders.put("/product").content(new ObjectMapper().writeValueAsString(product))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenProductWhenCallDeleteProductThenDeleteProduct()
            throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/product/{id}",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
