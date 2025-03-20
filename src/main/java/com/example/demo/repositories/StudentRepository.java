package com.example.demo.repositories;

import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.studentName = :name WHERE s.studentId = :id")
    void updateTheStudent(@Param("name") String name, @Param("id") Long id);
}
