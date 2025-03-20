package com.example.demo.controllers;

import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private StudentService studentService;

    @PostMapping("/saveStudent")
    public Student saveStudent(@PathVariable("student") Student student){
        return studentService.saveStudent(student);
    }

}
