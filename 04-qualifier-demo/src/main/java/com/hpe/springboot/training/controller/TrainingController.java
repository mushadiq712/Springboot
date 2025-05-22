package com.hpe.springboot.training.controller;

import com.hpe.springboot.training.component.Student;
import com.hpe.springboot.training.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {

    @GetMapping("/")
    public String hello() {
        return "Welcome to Spring Boot Training";
    }

    @GetMapping("/student")
    public String student() {
        return "Demo endpoint ! "+ person.introduce();
    }

    @GetMapping("/employee")
     public String employee(){
        return "Demo endpoint ! "+ person.introduce();
    }
    Person person;
    //Constructor Dependency Injection
    TrainingController(@Qualifier("employee") Person person){
        this.person = person;
    }

}
