package com.thnakrean.backend.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "course_level")
public class CourseLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
