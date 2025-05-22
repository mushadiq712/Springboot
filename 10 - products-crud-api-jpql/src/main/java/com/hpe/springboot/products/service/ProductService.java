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

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id){
        return this.productRepository.findById(id);
    }

    public void deleteProductById(Integer id){
        this.productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return this.productRepository.findProductsByCategory(category);
    }
    public int updatePriceByCategory(String category, Double price) {
        return this.productRepository.updatePriceByCategory(category, price);
    }
    public List<Product> findByTitle(String title) {
        return this.productRepository.findByTitle(title);
    }


}