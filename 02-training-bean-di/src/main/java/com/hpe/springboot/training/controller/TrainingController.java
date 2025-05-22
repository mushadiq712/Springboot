package com.hpe.springboot.training.controller;

import com.hpe.springboot.training.component.Student;
import org.springframework.beans.factory.annotation.Autowired;
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
        return "Demo endpoint!   "+student.introduce();
    }

    //Student student;


    //Constructor Dependency Injection
    /*TrainingController(Student student){
        this.student = student;
    }*/

   /* //Setter method Dependency Injection
    @Autowired
    public void setStudent(Student student){
        this.student=student;
    }*/

    // Field Dependency Injection
    @Autowired
    Student student;
}
