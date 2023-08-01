package com.thnakrean.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thnakrean.backend.dto.LectureDto;
import com.thnakrean.backend.service.LectureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/lectures")
@RequiredArgsConstructor

public class LectureController {
	private final LectureService lectureService;
	
	@PostMapping("{lectureId}")
	public ResponseEntity<?> createLecture(@RequestBody LectureDto lectureDto,
											@PathVariable("lectureId") Integer lectureId){
		lectureService.saveLecture(lectureDto, lectureId);
		return ResponseEntity.status(HttpStatus.CREATED).body("Create lecture successfully!");
	}
	@GetMapping("{curriculumId}")
	public ResponseEntity<List<LectureDto>> getLectureByCurriculumId(
											@PathVariable("curriculumId") Integer id){
		List<LectureDto> lectureByCurriculumId = lectureService.getLectureByCurriculumId(id);
		return ResponseEntity.ok(lectureByCurriculumId);
	}
	
}
