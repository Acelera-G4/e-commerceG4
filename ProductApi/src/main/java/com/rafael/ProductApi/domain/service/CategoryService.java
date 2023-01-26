package com.rafael.ProductApi.domain.service;

import com.rafael.ProductApi.domain.entity.Category;
import com.rafael.ProductApi.domain.entity.Product;
import com.rafael.ProductApi.domain.exception.CategoryNotFoundException;
import com.rafael.ProductApi.domain.exception.ProductNotFoundException;
import com.rafael.ProductApi.integration.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.rafael.ProductApi.domain.exception.CategoryNotFoundException.CATEGORY_NOT_FOUND;
import static com.rafael.ProductApi.domain.exception.ProductNotFoundException.PRODUCT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void postCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        } else {
            throw new CategoryNotFoundException(CATEGORY_NOT_FOUND);
        }
    }

    public void putCategory(Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(category.getCategoryId());
        if(optionalCategory.isPresent()){
            categoryRepository.save(category);
        } else {
            throw new CategoryNotFoundException(CATEGORY_NOT_FOUND);
        }
    }

    public void deleteCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            categoryRepository.deleteById(id);
        } else {
            throw new CategoryNotFoundException(CATEGORY_NOT_FOUND);
        }
    }
}
