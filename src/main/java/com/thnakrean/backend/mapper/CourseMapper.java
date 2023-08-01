package com.thnakrean.backend.mapper;

import com.thnakrean.backend.dto.CourseDto;
import com.thnakrean.backend.dto.CurriculumDto;
import com.thnakrean.backend.entities.Course;
import com.thnakrean.backend.entities.Curriculum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface CourseMapper {
	
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDto toCourseDto(Course course);
    Course toCourse(CourseDto courseDto);


}
