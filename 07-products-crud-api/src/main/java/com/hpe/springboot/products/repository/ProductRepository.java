package com.hpe.springboot.products.repository;

import com.hpe.springboot.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
