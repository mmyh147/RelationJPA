package com.example.day39.Controller;


import com.example.day39.Model.Course;
import com.example.day39.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/course")
public class CourseController {

    private final CourseService courseService;

    Logger logger = LoggerFactory.getLogger(CourseController.class);

    @GetMapping("get")
    public ResponseEntity getAllCourses(){
        logger.info("get all Courses");

        return ResponseEntity.status(200).body(courseService.getAll());
    }


    @PostMapping("add/{id}")
    public ResponseEntity addCourse(@RequestBody @Valid Course course, @PathVariable Integer id){

        logger.info("add new course");
        courseService.add(course, id);
        return ResponseEntity.ok("course added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course){
        logger.info("update course");
        courseService.update(id, course);
        return ResponseEntity.ok("Course updated");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        courseService.delete(id);
        return ResponseEntity.ok("Course deleted");
    }


    @GetMapping("get/teacher/name/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id){
        logger.info("get teacher name by ID : " + id);

        return ResponseEntity.status(200).body(courseService.getTeacherName(id));
    }
}
