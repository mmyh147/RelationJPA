package com.example.day39.Service;


import com.example.day39.Api.ApiException;
import com.example.day39.Model.Course;
import com.example.day39.Model.Student;
import com.example.day39.Model.Teacher;
import com.example.day39.Repository.CourseRepository;
import com.example.day39.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public List<Student> getAll() {
        return studentRepository.findAll();
    }


    public void add(Student student) {
        studentRepository.save(student);
    }

    public void update(Integer studentId, Student student) {
        if (studentRepository.existsById(studentId)) {
            student.setId(studentId);
            studentRepository.save(student);
        }else{
            throw new ApiException("student not found");

        }
    }

    public void delete(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new ApiException("student not found");
        }


    }


    public void changeMajor(Integer studentId, String major){
        Student student = studentRepository.findStudentById(studentId);
        if (student == null){
            throw new ApiException("Student not found");
        }

        student.setMajor(major);
        student.getCourses().clear();
        studentRepository.save(student);
    }

    public Set<Student> getStudentsByCourseId(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null){
            throw new ApiException("Course not found");
        }

        return course.getStudents();
    }
}
