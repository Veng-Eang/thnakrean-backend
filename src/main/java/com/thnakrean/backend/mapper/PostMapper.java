package com.thnakrean.backend.mapper;

import com.thnakrean.backend.dto.PostCourse;
import com.thnakrean.backend.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
    Course toCourse(PostCourse postCourse);
}
