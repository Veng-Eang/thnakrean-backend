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

import com.thnakrean.backend.dto.CurriculumDto;
import com.thnakrean.backend.service.CurriculumService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/curriculums")
@RequiredArgsConstructor
public class CurriculumController {
	private final CurriculumService curriculumService;
	
	
	@PostMapping("{courseId}")
	public ResponseEntity<?> createCurriculum(@RequestBody CurriculumDto curriculum,
											@PathVariable("courseId") Integer id){
		curriculumService.saveCurriculum(curriculum,id);
		return ResponseEntity.status(HttpStatus.CREATED).body("Create Curriculum successfully!");
	}
	
	@GetMapping("{courseId}")
	public ResponseEntity<List<CurriculumDto>> getAllCurriculum(
												@PathVariable("courseId") Integer courseId){
		List<CurriculumDto> curriculum = curriculumService.getCurriculumByCourseId(courseId);
		return ResponseEntity.ok(curriculum);
	}
	
}
