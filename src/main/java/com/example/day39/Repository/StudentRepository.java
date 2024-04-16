package com.example.day39.Repository;

import com.example.day39.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


    Student findStudentById(Integer id);
}
