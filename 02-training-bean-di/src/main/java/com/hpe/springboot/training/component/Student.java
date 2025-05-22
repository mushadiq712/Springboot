package com.hpe.springboot.training.component;


import com.hpe.springboot.training.model.Person;
import org.springframework.stereotype.Component;

@Component
public class Student implements Person {
    @Override
    public String introduce() {
        return "Welcome to class room Spring boot training";
    }
}
