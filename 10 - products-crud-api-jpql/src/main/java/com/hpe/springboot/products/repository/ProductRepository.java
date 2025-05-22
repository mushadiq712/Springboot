package com.hpe.springboot.products.repository;

import com.hpe.springboot.products.entity.Product;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(name = "Product.findByCategory")
    List<Product> findProductsByCategory(@Param("category") String category);

    @Modifying // used for do operations directly in DB instead of saving into local first and then saving into DB.
    @Transactional
    @Query("update Product p set p.price=:price where p.category=:category")
    int updatePriceByCategory(@Param("category") String category, @Param("price") Double price);

    //Native Sql Query

    @Query(value = "SELECT * FROM products WHERE LOWER(title) LIKE LOWER(CONCAT('%',:title,'%'))",
            nativeQuery = true)
    List<Product> findByTitle(@Param("title") String title);

}
