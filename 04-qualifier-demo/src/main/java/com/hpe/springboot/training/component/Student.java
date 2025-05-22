package com.hpe.springboot.training.component;


import com.hpe.springboot.training.model.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Student implements Person {
    @Override
    public String introduce() {
        return "Student";
    }
}
