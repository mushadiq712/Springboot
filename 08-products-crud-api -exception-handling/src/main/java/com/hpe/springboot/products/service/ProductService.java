package com.hpe.springboot.products.service;

import com.hpe.springboot.products.ProductsApplication;
import com.hpe.springboot.products.entity.Product;
import com.hpe.springboot.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

   final private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // For both save and update
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
}
