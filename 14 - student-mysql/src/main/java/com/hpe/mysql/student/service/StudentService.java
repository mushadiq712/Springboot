package com.hpe.mysql.student.service;

import com.hpe.mysql.student.Entity.Student;
import com.hpe.mysql.student.Repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    final private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // Used for both insert and update a product
    public Student saveStudent(Student product){
        return this.studentRepository.save(product);
    }

    public Page<Student> getAllStudents(Pageable pageable){
        return this.studentRepository.findAll(pageable);
    }

    public Optional<Student> getStudentById(Integer id){
        return this.studentRepository.findById(id);
    }

    public void deleteStudentById(Integer id){
        this.studentRepository.deleteById(id);
    }
}
