package com.hpe.springboot.products.controller;

import com.hpe.springboot.products.entity.Product;
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

    @GetMapping("/{productId}")
    public ResponseEntity<Product>  getProductById(@PathVariable Integer productId){
        Product product = this.productService.getProductById(productId).orElseThrow();
        return ResponseEntity.ok(product);
    }
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody Product product){
        this.productService.getProductById(productId).orElseThrow();
        product.setId(productId);
        return ResponseEntity.ok(this.productService.saveProduct(product));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        this.productService.getProductById(productId).orElseThrow();
        this.productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
