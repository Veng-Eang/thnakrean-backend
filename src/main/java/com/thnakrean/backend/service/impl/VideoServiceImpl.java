package com.thnakrean.backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.thnakrean.backend.dto.VideoDto;
import com.thnakrean.backend.entities.Lecture;
import com.thnakrean.backend.entities.Video;
import com.thnakrean.backend.exception.ResourceNotFoundException;
import com.thnakrean.backend.mapper.VideoMapper;
import com.thnakrean.backend.repository.LectureRepository;
import com.thnakrean.backend.repository.VideoRepository;
import com.thnakrean.backend.service.VideoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
	private final VideoRepository videoRepository;
	private final LectureRepository lectureRepository;
	
	@Override
	public List<VideoDto> getVideosByLectureId(Integer lectureId) {
		List<Video> videos = videoRepository.findByLectureId(lectureId);
		List<VideoDto> videoDtos = videos.stream()
				.map(v->VideoMapper.INSTANCE.toVideoDto(v))
				.collect(Collectors.toList());
		return videoDtos;
	}

	@Override
	public VideoDto getVideoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createVideo(VideoDto videoDto,Integer lectureId){
		Video video = VideoMapper.INSTANCE.toVideo(videoDto);
		Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(
				()->new ResourceNotFoundException("Lecture", lectureId));
		video.setLecture(lecture);
		videoRepository.save(video);
	}

}
