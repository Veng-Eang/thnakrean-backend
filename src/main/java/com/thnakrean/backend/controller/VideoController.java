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

import com.thnakrean.backend.dto.VideoDto;
import com.thnakrean.backend.service.VideoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/videos")
public class VideoController {
	private final VideoService videoService;
	
	@PostMapping("{lectureId}")
	public ResponseEntity<?> createVideo(@RequestBody VideoDto videoDto,
										@PathVariable("lectureId") Integer id){
		videoService.createVideo(videoDto, id);
		return ResponseEntity.status(HttpStatus.CREATED).body("Video create Successfully");
	}
	
	@GetMapping("{lectureId}")
	public ResponseEntity<List<VideoDto>> getVideoByLectureId(@PathVariable("lectureId") Integer id){
		List<VideoDto> videosByLectureId = videoService.getVideosByLectureId(id);
		return ResponseEntity.ok(videosByLectureId);
	}
	
}
