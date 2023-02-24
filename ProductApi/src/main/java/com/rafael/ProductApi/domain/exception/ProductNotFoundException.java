package com.rafael.ProductApi.domain.exception;

public class ProductNotFoundException extends RuntimeException{

    public static String PRODUCT_NOT_FOUND = "Produto não encontrado";
    public ProductNotFoundException(String message) {
        super(message);
    }
}
