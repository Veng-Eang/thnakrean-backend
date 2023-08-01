package com.thnakrean.backend.dto;

import com.thnakrean.backend.entities.Course;
import com.thnakrean.backend.mapper.CourseMapper;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;
@Data
public class CoursePageDto {
    private List<CourseDto> content;
    private PaginationDto pagination;

    public CoursePageDto(Page<?> page) {
        List<?> list = page.getContent();
        List<CourseDto> collectCourse = list.stream()
                .map(course-> CourseMapper.INSTANCE.toCourseDto((Course) course))
                .collect(Collectors.toList());
        this.content=collectCourse;
        this.pagination=PaginationDto.builder()
                .pageNumber(page.getPageable().getPageNumber()+1)
                .pageSize(page.getPageable().getPageSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .numberOfElements(page.getNumberOfElements())
                .empty(page.isEmpty())
                .first(page.isFirst())
                .last(page.isLast())
                .build();
    }
}
