package com.thnakrean.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.thnakrean.backend.dto.LectureDto;
import com.thnakrean.backend.entities.Lecture;

@Mapper
public interface LectureMapper {
	LectureMapper INSTANCE = Mappers.getMapper(LectureMapper.class);
	LectureDto toLectureDto(Lecture lecture);
	Lecture toLecture(LectureDto lectureDto);
}
