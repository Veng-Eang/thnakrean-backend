package com.thnakrean.backend.spec.filter;

import lombok.Data;

@Data
public class CourseFilter {
    private Integer id;
    private Integer categoryId;
    private String title;
}
