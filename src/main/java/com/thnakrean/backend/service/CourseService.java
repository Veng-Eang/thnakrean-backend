package com.thnakrean.backend.service;

import java.util.List;
import java.util.Map;

import com.thnakrean.backend.dto.CourseDto;
import com.thnakrean.backend.dto.CoursePageDto;

public interface CourseService {
    CoursePageDto getAllCourse(Map<String, String> params);
    CourseDto getCourseById(Integer id);
    void createCourse(CourseDto courseDto);
    CourseDto updateCourseById(CourseDto courseDto,Integer id);
    CoursePageDto getCoursesByCategoryId(Integer categoryId);
    void deleteCourseById(Integer courseId);
}
