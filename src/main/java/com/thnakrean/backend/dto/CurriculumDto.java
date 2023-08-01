package com.thnakrean.backend.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thnakrean.backend.entities.Lecture;

import lombok.Data;
@Data
public class CurriculumDto {
    private Integer id;
    private String name;
    
    @JsonIgnore
    private CourseDto course;

    private Set<LectureDto> lecture;
}
