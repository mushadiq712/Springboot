package com.hpe.student.controller;


import com.hpe.student.entity.Student;
import com.hpe.student.exception.StudentNotFoundException;
import com.hpe.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudents(Pageable pageable){
        return ResponseEntity.ok(this.studentService.getAllStudents(pageable));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.studentService.saveStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student){
        this.studentService.getStudentById(id).orElseThrow(()-> new StudentNotFoundException(id));
        student.setId(id);
        return ResponseEntity.ok(this.studentService.saveStudent(student));
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id){
       this.studentService.getStudentById(id).orElseThrow(()-> new StudentNotFoundException(id));
       this.studentService.deleteStudentById(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
   }

   @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
       Student student = this.studentService.getStudentById(id).orElseThrow(()-> new StudentNotFoundException(id));
       return ResponseEntity.ok(student);
   }
}
