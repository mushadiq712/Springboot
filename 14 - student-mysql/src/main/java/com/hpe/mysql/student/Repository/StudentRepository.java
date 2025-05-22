package com.hpe.mysql.student.Repository;

import com.hpe.mysql.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
