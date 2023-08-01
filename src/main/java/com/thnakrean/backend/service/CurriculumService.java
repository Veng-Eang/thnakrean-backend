package com.thnakrean.backend.service;

import java.util.List;

import com.thnakrean.backend.dto.CurriculumDto;

public interface CurriculumService {
	List<CurriculumDto> getCurriculumByCourseId(Integer id);
	void saveCurriculum(CurriculumDto curriculumDto,Integer courseId);
}
