package com.hpe.mongodemo.controller;

import com.hpe.mongodemo.entity.Product;
import com.hpe.mongodemo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Products API" ,description = "Operations related to Products")
public class ProductController {
    final private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

   @GetMapping
   @Operation(summary = "Get all Products",description = "This API returns list of Products")
   public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @PostMapping
    @Operation(summary = "create a new Product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.saveProduct(product));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Product by Id")
    public ResponseEntity<Product> getProductById(@PathVariable String id){
        Product product = this.productService.getProductById(id).orElseThrow();
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update product by Id")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product){
        this.productService.getProductById(id).orElseThrow();
        product.setId(id);
        return ResponseEntity.ok(this.productService.saveProduct(product));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product by Id")
    public ResponseEntity<?> deleteProduct(@PathVariable String id){
        this.productService.getProductById(id).orElseThrow();
        this.productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
