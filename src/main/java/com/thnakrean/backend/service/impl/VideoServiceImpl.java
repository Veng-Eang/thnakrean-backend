package com.thnakrean.backend.service.impl;

import com.thnakrean.backend.entities.Lecture;
import com.thnakrean.backend.entities.Video;
import com.thnakrean.backend.exception.ResourceNotFoundException;
import com.thnakrean.backend.repository.LectureRepository;
import com.thnakrean.backend.repository.VideoRepository;
import com.thnakrean.backend.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
	private final VideoRepository videoRepository;
	private final LectureRepository lectureRepository;
	
	@Override
	public List<Video> getVideosByLectureId(Integer lectureId) {
		List<Video> videos = videoRepository.findByLectureId(lectureId);
		return videos;
	}

	@Override
	public Video getVideoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createVideo(Video video,Integer lectureId){
		Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(
				()->new ResourceNotFoundException("Lecture", lectureId));
		video.setLecture(lecture);
		videoRepository.save(video);
	}

}
