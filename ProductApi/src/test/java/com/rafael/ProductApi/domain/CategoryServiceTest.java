package com.rafael.ProductApi.domain;

import com.rafael.ProductApi.ProductApiApplication;
import com.rafael.ProductApi.domain.entity.Category;
import com.rafael.ProductApi.domain.exception.CategoryNotFoundException;
import com.rafael.ProductApi.domain.exception.MainCategoryLimitExceededException;
import com.rafael.ProductApi.domain.service.CategoryService;
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
public class CategoryServiceTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void givenCategoryOnDatabaseWhenCallGetCategoriesThenReturnCategory() {

        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();

        categoryRepository.save(category);

        List<Category> categoryList = categoryService.getCategories();
        assertEquals(1, categoryList.size());
    }

    @Test
    public void givenNoCategoryOnDatabaseWhenCallGetCategoriesThenReturnEmpty() {

        List<Category> categoryList = categoryService.getCategories();
        assertEquals(0, categoryList.size());
    }

    @Test
    public void givenValidCategoryWhenCallPostCategoryThenSaveCategory() {
        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();
        categoryService.postCategory(category);
        List<Category> categoryList = categoryService.getCategories();
        assertEquals(1, categoryList.size());
    }

    @Test
    public void givenValidCategoryWhenCallPutCategoryThenUpdateCategory() {
        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();
        categoryService.postCategory(category);
        category.setMain(false);
        categoryService.putCategory(category);
        Category categoryUpdated = categoryService.getCategory(1L);
        assertFalse(categoryUpdated.isMain());
    }

    @Test
    public void givenNoCategoryOnDatabaseWhenCallDeleteCategoryThenThrowException() {
        assertThrows(CategoryNotFoundException.class, () ->
                categoryService.deleteCategory(1L));
    }

    @Test
    public void givenValidCategoryAndExceededMainCategoryWhenCallPostMainCategoryThenDontSaveCategory() {
        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();
        categoryRepository.save(category);
        category.setCategoryId(2L);
        categoryRepository.save(category);
        category.setCategoryId(3L);
        categoryRepository.save(category);
        category.setCategoryId(4L);
        categoryRepository.save(category);
        category.setCategoryId(5L);
        categoryRepository.save(category);
        assertThrows(MainCategoryLimitExceededException.class, () ->
                categoryService.postCategory(category));
    }

    @Test
    public void givenCategoryOnDatabaseWhenCallDeleteCategoryThenUpdateCategoryToInactive() {
        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();
        categoryRepository.save(category);
        categoryService.deleteCategory(1L);
        Category categoryInactive = categoryService.getCategory(1L);
        assertFalse(categoryInactive.isActive());
    }
}
