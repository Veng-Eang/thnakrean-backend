package com.thnakrean.backend.mapper;

import com.thnakrean.backend.dto.CourseDto;
import com.thnakrean.backend.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
	
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDto toCourseDto(Course course);
    Course toCourse(CourseDto courseDto);


}
