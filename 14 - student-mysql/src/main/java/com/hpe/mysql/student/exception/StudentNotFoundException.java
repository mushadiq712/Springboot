package com.hpe.mysql.student.exception;

public class StudentNotFoundException extends RuntimeException{

        public StudentNotFoundException(Integer id) {
            super("Product Not Found with id: " + id);
        }

}
