package com.hpe.springboot.training.component;


import com.hpe.springboot.training.model.Person;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Student implements Person {

    Student(){
        System.out.println("in student constructor");
    }

    @PostConstruct
    public void initStuff(){
        System.out.println("in student initStuff");
    }

    @Override
    public String introduce() {
        return "Welcome to class room Spring boot training";
    }

    @PreDestroy
    public void cleanupStuff(){
        System.out.println("in student cleanupStuff");
    }
}
