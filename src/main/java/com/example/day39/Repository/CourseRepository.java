package com.example.day39.Repository;

import com.example.day39.Model.Course;
import com.example.day39.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);

//    List<Student> findAllById(Integer id);
}
