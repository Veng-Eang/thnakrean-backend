package com.thnakrean.backend.service;

import java.util.List;

import com.thnakrean.backend.dto.VideoDto;

public interface VideoService {
	List<VideoDto> getVideosByLectureId(Integer lectureId);
	VideoDto getVideoById(Integer id);
	void createVideo(VideoDto videoDto,Integer lectureId);
}
