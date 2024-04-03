package com.example.day39.Service;

import com.example.day39.Api.ApiException;
import com.example.day39.Model.Teacher;
import com.example.day39.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;


    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }


    public void add(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void update(Integer teacherId, Teacher teacher) {
        if (teacherRepository.existsById(teacherId)) {
            teacher.setId(teacherId);
             teacherRepository.save(teacher);
        }else{
            throw new ApiException("teacher not found");

        }
    }

    public void delete(Integer id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
        } else {
            throw new ApiException("teacher not found");
        }


    }

    public Teacher getByID(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null){
            throw new ApiException("Teacher not found");
        }

        return teacher;
    }
}
