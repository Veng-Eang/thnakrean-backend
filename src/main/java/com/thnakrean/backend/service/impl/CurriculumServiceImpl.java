package com.thnakrean.backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.thnakrean.backend.dto.CourseDto;
import com.thnakrean.backend.dto.CurriculumDto;
import com.thnakrean.backend.entities.Course;
import com.thnakrean.backend.entities.Curriculum;
import com.thnakrean.backend.mapper.CourseMapper;
import com.thnakrean.backend.mapper.CurriculumMapper;
import com.thnakrean.backend.repository.CurriculumRepository;
import com.thnakrean.backend.service.CourseService;
import com.thnakrean.backend.service.CurriculumService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CurriculumServiceImpl implements CurriculumService {
	private final CurriculumRepository curriculumRepository;
	private final CourseService courseService;

	@Override
	public List<CurriculumDto> getCurriculumByCourseId(Integer id) {
		CourseDto courseDto = courseService.getCourseById(id);
		Course course = CourseMapper.INSTANCE.toCourse(courseDto);
		List<Curriculum> curriculum = curriculumRepository.findByCourseId(id);
		List<CurriculumDto> curriculumDtos = curriculum.stream()
				  .map(c -> CurriculumMapper.INSTANCE.toCurriculumDto(c))
				  .collect(Collectors.toList());
		return curriculumDtos;
	}

	@Override
	public void saveCurriculum(CurriculumDto curriculumDto,Integer courseId) {
		Curriculum curriculum = CurriculumMapper.INSTANCE.toCurriculum(curriculumDto);
		CourseDto courseDto = courseService.getCourseById(courseId);
		Course course = CourseMapper.INSTANCE.toCourse(courseDto);
		curriculum.setCourse(course);
		curriculumRepository.save(curriculum);
	}

}
