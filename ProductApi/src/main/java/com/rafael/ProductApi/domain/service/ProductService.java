package com.rafael.ProductApi.domain.service;

import com.rafael.ProductApi.domain.entity.Product;
import com.rafael.ProductApi.domain.exception.ProductNotFoundException;
import com.rafael.ProductApi.integration.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.rafael.ProductApi.domain.exception.ProductNotFoundException.PRODUCT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void postProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        } else {
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND);
        }
    }

    public void putProduct(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
        if(optionalProduct.isPresent()){
            productRepository.save(product);
        } else {
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND);
        }
    }

    public void deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(id);
        } else {
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND);
        }
    }


}
