package com.example.demo.repositories;

import com.example.demo.entities.Course;
import com.example.demo.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    @Transactional
    public void addCourseTestCaseToEffectTheChangesInTheDatabase(){
        CourseMaterial newCourseMaterial = CourseMaterial.builder()
                .materialName("Engineering Graphics Edition 2024E")
                .materialUrl("www.github.com/satishnadipalli/srenuiem")
                .build();
//        save(newCourseMaterial);

        Course newCourse = Course.builder()
                .CourseName("Engineering")
                .CourseCredit("6")
                .material(newCourseMaterial)
                .build();

        courseRepository.save(newCourse);
    }

    @Test
    public void printTheListOfCoursesTestCase(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }

}