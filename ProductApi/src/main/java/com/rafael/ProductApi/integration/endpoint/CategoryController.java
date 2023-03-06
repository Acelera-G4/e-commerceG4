package com.rafael.ProductApi.integration.endpoint;

import com.rafael.ProductApi.domain.entity.Category;
import com.rafael.ProductApi.domain.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Category> getCategory(@RequestParam Long categoryId) {
        return ResponseEntity.ok().body(categoryService.getCategory(categoryId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok().body(categoryService.getCategories());
    }

    @PostMapping
    public ResponseEntity<Category> postCategory(@RequestBody Category category) {
        categoryService.postCategory(category);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping
    public ResponseEntity<Category> putCategory(@RequestBody Category category) {
        categoryService.putCategory(category);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping
    public ResponseEntity deleteCategory(@RequestParam Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().body(null);
    }
}
