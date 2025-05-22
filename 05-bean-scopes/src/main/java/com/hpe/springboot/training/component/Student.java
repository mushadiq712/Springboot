package com.hpe.springboot.training.component;


import com.hpe.springboot.training.model.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student implements Person {
    @Override
    public String introduce() {
        return "Welcome to class room Spring boot training";
    }
}
