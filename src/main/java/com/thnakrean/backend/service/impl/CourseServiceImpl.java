package com.thnakrean.backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thnakrean.backend.conts.ContsKey;
import com.thnakrean.backend.dto.CourseDto;
import com.thnakrean.backend.dto.CoursePageDto;
import com.thnakrean.backend.dto.CurriculumDto;
import com.thnakrean.backend.dto.LectureDto;
import com.thnakrean.backend.entities.Course;
import com.thnakrean.backend.entities.Curriculum;
import com.thnakrean.backend.entities.Lecture;
import com.thnakrean.backend.exception.ResourceNotFoundException;
import com.thnakrean.backend.mapper.CourseMapper;
import com.thnakrean.backend.mapper.CurriculumMapper;
import com.thnakrean.backend.mapper.LectureMapper;
import com.thnakrean.backend.repository.CourseRepository;
import com.thnakrean.backend.repository.CurriculumRepository;
import com.thnakrean.backend.repository.LectureRepository;
import com.thnakrean.backend.service.CourseService;
import com.thnakrean.backend.spec.CourseFilter;
import com.thnakrean.backend.spec.CourseSpec;
import com.thnakrean.backend.utils.PageUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CurriculumRepository curriculumRepository;
    private final LectureRepository lectureRepository;

    @Override
    public CoursePageDto getAllCourse(Map<String, String> params) {
        CourseFilter courseFilter = new CourseFilter();
        if(params.containsKey(ContsKey.ID)){
            String id = params.get(ContsKey.ID);
            courseFilter.setId(Integer.parseInt(id));
        }
        if(params.containsKey(ContsKey.CATEGORY)){
            String category = params.get(ContsKey.CATEGORY);
            courseFilter.setCategoryId(Integer.parseInt(category));
            System.out.println("CategoryId : " +category);
        }
        if(params.containsKey(ContsKey.TITLE)){
            String title = params.get(ContsKey.TITLE);
            courseFilter.setTitle(title);
        }
        int pageNumber= PageUtil.DEFAULT_PAGE_NUMBER;
        if(params.containsKey(PageUtil.PAGE_NUMBER)){
            String pageNum=params.get(PageUtil.PAGE_NUMBER);
            pageNumber=Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
        }
        int pageSize=PageUtil.DEFAULT_PAGE_SIZE;
        if(params.containsKey(PageUtil.PAGE_LIMIT)){
            pageSize=Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
        }
        CourseSpec courseSpec =new CourseSpec(courseFilter);
        Pageable pageable = PageUtil.getPageable(pageNumber,pageSize);
        Page<Course> coursePage = courseRepository.findAll(courseSpec, pageable);
        System.out.println(coursePage.getContent());
        CoursePageDto coursePageDto = new CoursePageDto(coursePage);
        return coursePageDto;
    }
    @Override
    public CourseDto getCourseById(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course ", id));
        List<Curriculum> findByCourse = curriculumRepository.findByCourse(course);
        Set<CurriculumDto> curriculumDto = findByCourse.stream()
        					.map(c->CurriculumMapper.INSTANCE.toCurriculumDto(c))
        					.collect(Collectors.toSet());
        CourseDto courseDto = CourseMapper.INSTANCE.toCourseDto(course);
        curriculumDto.stream().forEach(c->{
        				c.setLecture(getLectureDtoByCurriculumId(c.getId()));
        			});
        courseDto.setCurriculum(curriculumDto);
        
        return courseDto;
        
    }
    private Set<LectureDto> getLectureDtoByCurriculumId(Integer id) {
    	List<Lecture> lectures = lectureRepository.findByCurriculumId(id);
    	return lectures.stream()
    			.map(l->LectureMapper.INSTANCE.toLectureDto(l))
    			.collect(Collectors.toSet());
    }
    

    @Override
    public void createCourse(CourseDto courseDto) {
        Course course = CourseMapper.INSTANCE.toCourse(courseDto);
        courseRepository.save(course);
    }

	@Override
	public CourseDto updateCourseById(CourseDto courseDto, Integer id) {
		Course course = courseRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("course", id));
		System.out.println("Before"+course);
		courseDto.setUpdatedTime(LocalDateTime.now());
		
		course = CourseMapper.INSTANCE.toCourse(courseDto);
		course.setId(id);
		System.out.println("After: "+course);
		courseRepository.save(course);
		return CourseMapper.INSTANCE.toCourseDto(course);
	}

    @Override
    public CoursePageDto getCoursesByCategoryId(Integer categoryId) {
        List<Course> coursesByCategoryId = courseRepository.findCoursesByCategoryId(categoryId);
        return null;
    }

    @Override
    public void deleteCourseById(Integer courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course ", courseId)
        );
        courseRepository.delete(course);
    }
}
