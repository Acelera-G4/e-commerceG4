package com.rafael.ProductApi.domain;

import com.rafael.ProductApi.ProductApiApplication;
import com.rafael.ProductApi.domain.entity.Category;
import com.rafael.ProductApi.domain.entity.Product;
import com.rafael.ProductApi.domain.exception.ProductNotFoundException;
import com.rafael.ProductApi.domain.service.ProductService;
import com.rafael.ProductApi.integration.repository.CategoryRepository;
import com.rafael.ProductApi.integration.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ProductApiApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductServiceTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void givenProductOnDatabaseWhenCallGetProductsThenReturnProduct() {

        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();
        categoryRepository.save(category);

        Product product = Product.builder()
                .withProductId(1L)
                .withName("Product Test")
                .withDescription("Description Test")
                .withImage("image.png")
                .withPrice(9.99)
                .withIsActive(true)
                .withCategory(category)
                .build();
        productRepository.save(product);

        List<Product> productList = productService.getProducts();
        assertEquals(1, productList.size());
    }

    @Test
    public void givenNoProductOnDatabaseWhenCallGetProductssThenReturnEmpty() {
        List<Product> productList = productService.getProducts();
        assertEquals(0, productList.size());
    }

    @Test
    public void givenValidProductWhenCallPostProductThenSaveProduct() {
        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();
        categoryRepository.save(category);

        Product product = Product.builder()
                .withProductId(1L)
                .withName("Product Test")
                .withDescription("Description Test")
                .withImage("image.png")
                .withPrice(9.99)
                .withIsActive(true)
                .withCategory(category)
                .build();

        productService.postProduct(product);
        List<Product> productList = productService.getProducts();

        assertEquals(1, productList.size());
    }

    @Test
    public void givenValidProductWhenCallPutProductThenUpdateProduct() {
        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();
        categoryRepository.save(category);

        Product product = Product.builder()
                .withProductId(1L)
                .withName("Product Test")
                .withDescription("Description Test")
                .withImage("image.png")
                .withPrice(9.99)
                .withIsActive(true)
                .withCategory(category)
                .build();

        productService.postProduct(product);
        product.setPrice(99.99);
        productService.putProduct(product);
        Product productUpdated = productService.getProduct(1L);
        Double price = 99.99;
        assertEquals(price, productUpdated.getPrice());
    }

    @Test
    public void givenNoProductOnDatabaseWhenCallDeleteProductThenThrowException() {
        assertThrows(ProductNotFoundException.class, () ->
                productService.deleteProduct(1L));
    }

    @Test
    public void givenProductOnDatabaseWhenCallDeleteProductThenUpdateProductToInactive() {
        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();
        categoryRepository.save(category);

        Product product = Product.builder()
                .withProductId(1L)
                .withName("Product Test")
                .withDescription("Description Test")
                .withImage("image.png")
                .withPrice(9.99)
                .withIsActive(true)
                .withCategory(category)
                .build();
        productRepository.save(product);
        productService.deleteProduct(1L);

        Product productInactive = productService.getProduct(1L);
        assertFalse(productInactive.isActive());
    }
}
