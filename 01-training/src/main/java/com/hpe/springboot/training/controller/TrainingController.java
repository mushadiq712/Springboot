package com.hpe.springboot.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {

    @GetMapping("/")
    public String hello() {
        return "Welcome to Spring Boot Training";
    }
    @GetMapping("/demo")
    public String demo() {
        return "Demo endpoint!";
    }
}
