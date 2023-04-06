package com.rafael.ProductApi.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael.ProductApi.domain.entity.Category;
import com.rafael.ProductApi.domain.service.CategoryService;
import com.rafael.ProductApi.integration.endpoint.CategoryController;
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
@WebMvcTest(CategoryController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CategoryControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void givenCategoryWhenCallGetCategoriesThenReturnCategories()
            throws Exception {
        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();

        given(categoryService.getCategories()).willReturn(Collections.singletonList(category));

        mvc.perform(MockMvcRequestBuilders.get("/category")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty());
    }

    @Test
    public void givenMainCategoryWhenCallGetCategoriesThenReturnMainCategories()
            throws Exception {
        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();

        given(categoryService.getMainCategories()).willReturn(Collections.singletonList(category));

        mvc.perform(MockMvcRequestBuilders.get("/category/main")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty());
    }

    @Test
    public void givenNoCategoryWhenCallGetCategoriesThenReturnEmptyList()
            throws Exception {
        given(categoryService.getCategories()).willReturn(Collections.emptyList());

        mvc.perform(MockMvcRequestBuilders.get("/category")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    public void givenCategoryWhenCallGetCategoryThenReturnCategory()
            throws Exception {
        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();

        given(categoryService.getCategory(any())).willReturn(category);

        mvc.perform(MockMvcRequestBuilders.get("/category/{id}",1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").isNotEmpty());
    }

    @Test
    public void givenCategoryWhenCallPutCategoryThenUpdateCategory()
            throws Exception {
        Category category = Category.builder()
                .withCategoryId(1L)
                .withName("Category Test")
                .withDescription("Category Description")
                .withIsMain(true)
                .build();

        mvc.perform(MockMvcRequestBuilders.put("/category").content(new ObjectMapper().writeValueAsString(category))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenCategoryWhenCallDeleteCategoryThenDeleteCategory()
            throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/category/{id}",1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
