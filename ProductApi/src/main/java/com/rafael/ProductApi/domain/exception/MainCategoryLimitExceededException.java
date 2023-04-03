package com.rafael.ProductApi.domain.exception;

public class MainCategoryLimitExceededException extends RuntimeException{

    public static String LIMIT_EXCEEDED = "Número máximo de categorias principais excedido";
    public MainCategoryLimitExceededException(String message) {
        super(message);
    }
}