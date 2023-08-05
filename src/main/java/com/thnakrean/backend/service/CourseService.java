package com.thnakrean.backend.service;

import java.util.List;
import java.util.Map;

import com.thnakrean.backend.dto.CourseDto;
import com.thnakrean.backend.dto.CoursePageDto;
import com.thnakrean.backend.dto.PostCourse;

public interface CourseService {

    CoursePageDto getAllCourse(Map<String, String> params);
    CourseDto getCourseById(Integer id);
    CourseDto updateCourseById(CourseDto courseDto,Integer id);
    void createCourse(PostCourse postCourse);
    void deleteCourseById(Integer courseId);
}
