package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_seq",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_seq"
    )
    private Long materialId;
    private String materialName;
    private String materialUrl;

    @OneToOne(mappedBy = "material") //This material is the field name created in the Course Class for this material
    private Course course;


}
