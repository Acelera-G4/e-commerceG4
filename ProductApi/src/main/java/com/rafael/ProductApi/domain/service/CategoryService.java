package com.rafael.ProductApi.domain.service;

import com.rafael.ProductApi.domain.entity.Category;
import com.rafael.ProductApi.domain.exception.CategoryNotFoundException;
import com.rafael.ProductApi.domain.exception.MainCategoryLimitExceededException;
import com.rafael.ProductApi.integration.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rafael.ProductApi.domain.exception.CategoryNotFoundException.CATEGORY_NOT_FOUND;
import static com.rafael.ProductApi.domain.exception.MainCategoryLimitExceededException.LIMIT_EXCEEDED;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void postCategory(Category category) {
        if(exceededLimit()) {
            throw new MainCategoryLimitExceededException(LIMIT_EXCEEDED);
        }
        categoryRepository.save(category);
    }

    private boolean exceededLimit() {
        return categoryRepository.findAll().stream().filter(Category::isMain).count() >= 5;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> getMainCategories() {
        return categoryRepository.findAll().stream().filter(Category::isMain).collect(Collectors.toList());
    }

    public Category getCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        } else {
            throw new CategoryNotFoundException(CATEGORY_NOT_FOUND);
        }
    }

    public void putCategory(Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(category.getCategoryId());
        if(exceededLimit()) {
            throw new MainCategoryLimitExceededException(LIMIT_EXCEEDED);
        }
        if(optionalCategory.isPresent()){
            categoryRepository.save(category);
        } else {
            throw new CategoryNotFoundException(CATEGORY_NOT_FOUND);
        }
    }

    public void deleteCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            categoryRepository.deleteById(id);
        } else {
            throw new CategoryNotFoundException(CATEGORY_NOT_FOUND);
        }
    }
}
