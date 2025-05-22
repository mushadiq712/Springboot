package com.example.products.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Integer productId) {
        super("Product Not Found with id: " + productId);
    }
}
