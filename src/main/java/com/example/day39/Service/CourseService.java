package com.example.day39.Service;

import com.example.day39.Api.ApiException;
import com.example.day39.Model.Course;
import com.example.day39.Model.Teacher;
import com.example.day39.Repository.CourseRepository;
import com.example.day39.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {


    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course> getAll() {
        return courseRepository.findAll();
    }


    public Course add(Course course, Integer teacher_id) {
        if (!teacherRepository.existsById(teacher_id)){
            throw new ApiException("teacher with ID: " + teacher_id + " not found");
        }
        course.setTeacher(teacherRepository.findTeacherById(teacher_id));
        return courseRepository.save(course);
    }

    public Course update(Integer courseId, Course course) {
        if (courseRepository.existsById(courseId)) {
            course.setId(courseId);
            return courseRepository.save(course);
        }
        throw new ApiException("course not found");
    }

    public void delete(Integer id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            throw new ApiException("course not found");
        }


    }

    public String getTeacherName(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course == null){
            throw new ApiException("No course found with ID : " + id);
        }
        if (course.getTeacher().getName() == null){
            throw new ApiException("No teacher assign to course");
        }
        return course.getTeacher().getName();
    }

}
