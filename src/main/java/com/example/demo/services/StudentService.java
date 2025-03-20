package com.example.demo.services;

import com.example.demo.entities.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    Student saveStudent(Student student);

    Student updateStudent(Long studentId);

    Student updateStudent(Long studentId, Student studentData);
}
