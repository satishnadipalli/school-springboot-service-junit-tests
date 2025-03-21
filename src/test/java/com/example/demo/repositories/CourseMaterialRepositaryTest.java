package com.example.demo.repositories;

import com.example.demo.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositaryTest {

    @Autowired
    private CourseMaterialRepositary courseMaterialRepositary;

    @Test
    public void getCourseMaterialTestCase(){
        List<CourseMaterial> materialList = courseMaterialRepositary.findAll();
        System.out.println(materialList);
    }
}