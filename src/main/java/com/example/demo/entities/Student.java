package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@SequenceGenerator(
        name = "student_seq",
        sequenceName = "student_sequence",
        allocationSize = 1

)
public class Student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq"
    )
    private Long studentId;
    private String studentName;
    private int studentAge;

    @Embedded
    private Guardian guardian;

    @OneToOne
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "CourseId"
    )
    private Course course;
}
