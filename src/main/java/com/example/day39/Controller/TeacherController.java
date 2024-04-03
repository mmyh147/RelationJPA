package com.example.day39.Controller;

import com.example.day39.Model.Teacher;
import com.example.day39.Repository.TeacherRepository;
import com.example.day39.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teacher")
public class TeacherController {


    private final TeacherService teacherService;
    Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @GetMapping("get")
    public ResponseEntity getAllTeacher(){
        logger.info("get all teacher");

        return ResponseEntity.status(200).body(teacherService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){

        logger.info("add new teacher");
        teacherService.add(teacher);
        return ResponseEntity.ok("teacher added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        logger.info("update teacher");
        teacherService.update(id, teacher);
        return ResponseEntity.ok("teacher updated");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        teacherService.delete(id);
        return ResponseEntity.ok("Teacher deleted");
    }

    @GetMapping("get-teacher/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id){
        logger.info("delete teacher");
        Teacher teacher = teacherService.getByID(id);
        return ResponseEntity.ok(teacher);
    }}
