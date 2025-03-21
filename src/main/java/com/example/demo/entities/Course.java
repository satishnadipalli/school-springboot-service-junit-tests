package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString(exclude = "material")
public class Course {

    @SequenceGenerator(
            name = "course_seq",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_seq"
    )
    private Long CourseId;
    private String CourseName;
    private String CourseCredit;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER

    )
    @JoinColumn(
            name = "material_id",
            referencedColumnName = "materialId"

    )
    private CourseMaterial material;

}
