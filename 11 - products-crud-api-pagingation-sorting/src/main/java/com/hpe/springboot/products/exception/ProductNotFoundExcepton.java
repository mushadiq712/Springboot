package com.hpe.springboot.products.exception;

public class ProductNotFoundExcepton extends RuntimeException {

    public ProductNotFoundExcepton(Integer productId) {
        super("Product Not Found with id: " + productId);
    }
}
