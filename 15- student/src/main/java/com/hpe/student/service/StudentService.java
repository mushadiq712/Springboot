package com.hpe.student.service;


import com.hpe.student.entity.Student;
import com.hpe.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    // Used for both insert and update a product
    public Student saveStudent(Student student){
        return this.studentRepository.save(student);
    }

    public Page<Student> getAllStudents(Pageable pageable){
        return this.studentRepository.findAll(pageable);
    }

    public Optional<Student> getStudentById(String id){
        return this.studentRepository.findById(id);
    }

    public void deleteStudentById(String id){
        this.studentRepository.deleteById(id);
    }
}
