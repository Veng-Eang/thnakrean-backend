package com.thnakrean.backend.mapper;

import com.thnakrean.backend.dto.LectureDto;
import com.thnakrean.backend.entities.Lecture;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LectureMapper {
    LectureMapper INSTANCE = Mappers.getMapper(LectureMapper.class);
    LectureDto toLectureDtoDto(Lecture lecture);
    Lecture toLecture(LectureDto lectureDto);
}
