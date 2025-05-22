package com.hpe.springboot.training.controller;

import com.hpe.springboot.training.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {

    @GetMapping("/")
    public String hello() {
        return "Welcome to Spring Boot Training";
    }
    @GetMapping("/student")
    public String introduceStudent() {
        return "Demo endpoint!   "+person.introduce();
    }

    @GetMapping("/check")
    public String check(){
        return "person == another person "+(this.person==this.person2);
    }
    Person person;
    Person person2;
    //Constructor Dependency Injection
    TrainingController(Person person, Person person2){
        this.person = person;
        this.person2 = person2;
    }

}
