package com.example.day39.Controller;

import com.example.day39.Model.Student;
import com.example.day39.Model.Teacher;
import com.example.day39.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Student")
public class StudentController {


    private final StudentService studentService;


    Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @GetMapping("get")
    public ResponseEntity getAllStudent(){
        logger.info("get all student");

        return ResponseEntity.status(200).body(studentService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity addstudent(@RequestBody @Valid Student student){

        logger.info("add new student");
        studentService.add(student);
        return ResponseEntity.ok("student added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student){
        logger.info("update student");
        studentService.update(id, student);
        return ResponseEntity.ok("student updated");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        studentService.delete(id);
        return ResponseEntity.ok("student deleted");
    }


    @PutMapping("/{studentId}/{major}")
    public ResponseEntity<String> changeStudentMajor(@PathVariable Integer studentId, @PathVariable String major) {
        studentService.changeMajor(studentId, major);
        return ResponseEntity.ok("Student major changed successfully.");
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity getStudentsByCourseId(@PathVariable Integer courseId) {
        Set<Student> students = studentService.getStudentsByCourseId(courseId);
        return ResponseEntity.ok(students);
    }
}
