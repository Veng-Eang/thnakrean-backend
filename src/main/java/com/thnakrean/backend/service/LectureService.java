package com.thnakrean.backend.service;

import java.util.List;

import com.thnakrean.backend.dto.LectureDto;

public interface LectureService {
	List<LectureDto> getLectureByCurriculumId(Integer id);
	void saveLecture(LectureDto lectureDto,Integer curriculumId);
}
