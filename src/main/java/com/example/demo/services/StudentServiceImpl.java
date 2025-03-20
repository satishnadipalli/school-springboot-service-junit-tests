package com.example.demo.services;

import com.example.demo.entities.Guardian;
import com.example.demo.entities.Student;
import com.example.demo.errorHandler.ResourceNotFoundException;
import com.example.demo.repositories.StudentRepository;

public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        if(student.getStudentAge() <= 0){
            throw new ResourceNotFoundException("Please enter a valid Student Name");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long studentId) {
        return null;
    }

    @Override
    public Student updateStudent(Long studentId, Student studentData) {
        Student studentWithId = studentRepository.findById(studentId).orElse(null);

        studentWithId.setStudentAge(studentData.getStudentAge());
        studentWithId.setStudentName(studentData.getStudentName());

        if (studentWithId == null) {
            throw new RuntimeException("Student with ID " + studentId + " not found.");
        }

        // Update student details
        if (studentData.getStudentAge() >0) {
            studentWithId.setStudentAge(studentData.getStudentAge());
        }

        if (studentData.getStudentName() != null) {
            studentWithId.setStudentName(studentData.getStudentName());
        }

        // Update Guardian only if it's not null
        if (studentData.getGuardian() != null) {
            Guardian updatedGuardian = new Guardian(
                    studentData.getGuardian().getName(),
                    studentData.getGuardian().getEmail(),
                    studentData.getGuardian().getPhone()
            );
            studentWithId.setGuardian(updatedGuardian);
        }


        return studentRepository.save(studentWithId);
    }
}
