package com.thnakrean.backend.service;

import com.thnakrean.backend.entities.Video;

import java.util.List;

public interface VideoService {
	List<Video> getVideosByLectureId(Integer lectureId);
	Video getVideoById(Integer id);
	void createVideo(Video videoDto, Integer lectureId);
}
