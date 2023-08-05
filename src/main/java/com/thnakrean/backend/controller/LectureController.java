package com.thnakrean.backend.controller;

import java.util.List;

import com.thnakrean.backend.dto.LectureDto;
import com.thnakrean.backend.entities.Lecture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thnakrean.backend.service.LectureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/lectures")
@RequiredArgsConstructor

public class LectureController {
	private final LectureService lectureService;

	@GetMapping("{courseId}")
	public ResponseEntity<?> listLecture(@PathVariable("courseId") Integer courseId){
		List<LectureDto> lectureAndVideoByCourseId = lectureService.getLectureAndVideoByCourseId(courseId);
		return ResponseEntity.ok(lectureAndVideoByCourseId);
	}
	
}
