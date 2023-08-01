package com.thnakrean.backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.thnakrean.backend.dto.LectureDto;
import com.thnakrean.backend.entities.Curriculum;
import com.thnakrean.backend.entities.Lecture;
import com.thnakrean.backend.exception.ResourceNotFoundException;
import com.thnakrean.backend.mapper.LectureMapper;
import com.thnakrean.backend.repository.CurriculumRepository;
import com.thnakrean.backend.repository.LectureRepository;
import com.thnakrean.backend.service.CurriculumService;
import com.thnakrean.backend.service.LectureService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
	private final LectureRepository lectureRepository;
	private final CurriculumRepository curriculumRepository;

	@Override
	public List<LectureDto> getLectureByCurriculumId(Integer id) {
		List<Lecture> lectures = lectureRepository.findByCurriculumId(id);
		List<LectureDto> lectureDtos = lectures.stream().map(lecture->LectureMapper.INSTANCE.toLectureDto(lecture))
						.collect(Collectors.toList());
		return lectureDtos;
	}

	@Override
	public void saveLecture(LectureDto lectureDto,Integer curriculumId) {
		Lecture lecture = LectureMapper.INSTANCE.toLecture(lectureDto);
		Curriculum curriculum = curriculumRepository.findById(curriculumId).orElseThrow(
				()-> new ResourceNotFoundException("Curriculum", curriculumId));
		lecture.setCurriculum(curriculum);
		lectureRepository.save(lecture);
	}

}
