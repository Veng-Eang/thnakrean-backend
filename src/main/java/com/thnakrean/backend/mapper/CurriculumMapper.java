package com.thnakrean.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.thnakrean.backend.dto.CurriculumDto;
import com.thnakrean.backend.entities.Curriculum;

@Mapper( uses= {CourseMapper.class})
public interface CurriculumMapper {
    CurriculumMapper INSTANCE= Mappers.getMapper(CurriculumMapper.class);
    CurriculumDto toCurriculumDto(Curriculum curriculum);
    Curriculum toCurriculum(CurriculumDto curriculumDto);
}
