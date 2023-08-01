package com.thnakrean.backend.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "course_language")
public class CourseLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
