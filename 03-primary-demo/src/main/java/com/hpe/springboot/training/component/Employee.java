package com.hpe.springboot.training.component;

import com.hpe.springboot.training.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Employee implements Person {
    @Override
    public String introduce() {
        return "Employee";
    }
}
