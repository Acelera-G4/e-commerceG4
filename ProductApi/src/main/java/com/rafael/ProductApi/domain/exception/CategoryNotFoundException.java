package com.rafael.ProductApi.domain.exception;

public class CategoryNotFoundException extends RuntimeException{

    public static String CATEGORY_NOT_FOUND = "Categoria não encontrada";
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
