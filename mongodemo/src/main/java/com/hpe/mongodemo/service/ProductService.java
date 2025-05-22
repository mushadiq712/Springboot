package com.hpe.mongodemo.service;

import com.hpe.mongodemo.entity.Product;
import com.hpe.mongodemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product){
        return this.productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public Optional<Product> getProductById(String id){
        return this.productRepository.findById(id);
    }

    public void deleteProduct(String id){
        this.productRepository.deleteById(id);
    }

}
