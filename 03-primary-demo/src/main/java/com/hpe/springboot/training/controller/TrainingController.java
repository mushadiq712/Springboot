package com.hpe.springboot.training.controller;

import com.hpe.springboot.training.component.Student;
import com.hpe.springboot.training.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {

    @GetMapping("/")
    public String hello() {
        return "Welcome to Spring Boot Training";
    }

    @GetMapping("/introduceStudent")
    public String introduceStudent() {
        return "Demo endpoint ! "+ person.introduce();
    }

    Person person;

    //Constructor Dependency Injection
    TrainingController(Person person){
        this.person = person;
    }

}
