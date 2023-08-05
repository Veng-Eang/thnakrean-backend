package com.thnakrean.backend.service.impl;

import com.thnakrean.backend.dto.CourseViewVideo;
import com.thnakrean.backend.dto.LectureDto;
import com.thnakrean.backend.entities.Lecture;
import com.thnakrean.backend.mapper.LectureMapper;
import com.thnakrean.backend.repository.LectureRepository;
import com.thnakrean.backend.repository.VideoRepository;
import com.thnakrean.backend.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
	private final LectureRepository lectureRepository;
	private final VideoRepository videoRepository;


	@Override
	public List<LectureDto> getLectureAndVideoByCourseId(Integer courseId) {
		List<Lecture> lectures = lectureRepository.findLecturesByCourseId(courseId);
		List<LectureDto> lectureDtos = lectures.stream()
												.map(lecture -> LectureMapper.INSTANCE.toLectureDtoDto(lecture))
												.collect(Collectors.toList());
		lectureDtos.stream().forEach(lectureDto -> {
			videoRepository.findByLectureId(lectureDto.getId()).stream().forEach(video -> {

				lectureDto.addVideo(video);
			});
		});
		return lectureDtos;
	}
}
