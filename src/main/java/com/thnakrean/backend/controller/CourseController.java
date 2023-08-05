package com.thnakrean.backend.controller;

import com.thnakrean.backend.dto.CourseDto;
import com.thnakrean.backend.dto.CoursePageDto;
import com.thnakrean.backend.dto.PostCourse;
import com.thnakrean.backend.service.CourseService;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;


    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody PostCourse postCourse){
        courseService.createCourse(postCourse);
        return  ResponseEntity.status(HttpStatus.CREATED).body("create successfully");
    }

    @GetMapping()
    public ResponseEntity<CoursePageDto> getAllCourse(@RequestParam Map<String,String> params){
        CoursePageDto course = courseService.getAllCourse(params);
        return ResponseEntity.ok(course);
    }
    @GetMapping("{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") Integer id){
        CourseDto courseDto = courseService.getCourseById(id);
        return ResponseEntity.ok(courseDto);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto,
    								@PathVariable("id") Integer id){
    	CourseDto courseUpdate = courseService.updateCourseById(courseDto, id);
    	return ResponseEntity.ok(courseUpdate);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Integer id){
        courseService.deleteCourseById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Delete course with Id "+id+" successfully.");
    }

}













