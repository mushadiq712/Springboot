package com.hpe.springboot.products.controller;


import com.hpe.springboot.products.entity.Product;
import com.hpe.springboot.products.exception.ProductNotFoundExcepton;
import com.hpe.springboot.products.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    final private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.saveProduct(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){
        Product product = this.productService.getProductById(id).orElseThrow(()-> new ProductNotFoundExcepton(id));
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product){
        this.productService.getProductById(id).orElseThrow(()-> new ProductNotFoundExcepton(id));
        product.setId(id);
        return ResponseEntity.ok(this.productService.saveProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        this.productService.getProductById(id).orElseThrow(()-> new ProductNotFoundExcepton(id));
        this.productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
