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
@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoryService.getCategory(id));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok().body(categoryService.getCategories());
    }

    @GetMapping("/main")
    public ResponseEntity<List<Category>> getMainCategories() {
        return ResponseEntity.ok().body(categoryService.getMainCategories());
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

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().body(null);
    }
}
