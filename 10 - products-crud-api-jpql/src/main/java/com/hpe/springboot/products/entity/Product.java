package com.hpe.springboot.products.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@NamedQueries({
                @NamedQuery(name = "Product.findByCategory",query = "select p from Product p where p.category=:category"),
                @NamedQuery(name = "Product.updatePriceByCategory",query = "update Product p set p.price=:price where p.category=:category")
        })
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "title")
    @NotEmpty(message = "Title should not be empty")
    @Min(message = "Title should be at least 3 characters", value = 3)
    @Max(message = "Title should be at most 50 characters", value = 50)
    String title;
    @NotEmpty(message = "Category is required")
    String category;
    @PositiveOrZero(message = "Price should be positive or zero")
    Double price;

    // Default constructor and Setter/Getter methods - POJO - Plain Object Java Object

    public Product(){
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
