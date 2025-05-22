package com.hpe.student.exception;

public class StudentNotFoundException extends RuntimeException{

        public StudentNotFoundException(String id) {
            super("Product Not Found with id: " + id);
        }

}
