package com.hpe.springboot.products.service;


import com.hpe.springboot.products.entity.Product;
import com.hpe.springboot.products.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    final private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    // Used for both insert and update a product
    public Product saveProduct(Product product){
        return this.productRepository.save(product);
    }

    public Page<Product> getAllProducts(Pageable pageable){
        return this.productRepository.findAll(pageable);
    }

    public Optional<Product> getProductById(Integer id){
        return this.productRepository.findById(id);
    }

    public void deleteProductById(Integer id){
        this.productRepository.deleteById(id);
    }
}