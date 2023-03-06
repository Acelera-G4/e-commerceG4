package com.rafael.ProductApi.integration.endpoint;

import com.rafael.ProductApi.domain.entity.Product;
import com.rafael.ProductApi.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<Product> getProduct(@RequestParam Long id) {
        return ResponseEntity.ok().body(productService.getProduct(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody Product product) {
        productService.postProduct(product);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping
    public ResponseEntity<Product> putProduct(@RequestBody Product product) {
        productService.putProduct(product);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping
    public ResponseEntity deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().body(null);
    }
}
