package com.example.demo.repositories;

import com.example.demo.entities.Guardian;
import com.example.demo.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentREpository;

    @Test
    public void addStudentTestCase(){
        Guardian Srinivasarao = Guardian.builder()
                .email("srinivasaraonadipalli1@gmail.com")
                .name("Kannathalli Nadipalli")
                .phone("8978985915")
                .build();
        Student satish = Student.builder()
                .studentAge(20)
                .studentName("Satish Nadipalli")
                .guardian(Srinivasarao)
                .build();

        studentREpository.save(satish);
    }


    @Test
    public void updateStudent(){

        studentREpository.updateTheStudent("SriKanna Nadipalli", 1L);

    }

}