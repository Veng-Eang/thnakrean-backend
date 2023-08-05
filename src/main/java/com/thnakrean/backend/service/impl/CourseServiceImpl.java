package com.thnakrean.backend.service.impl;

import com.thnakrean.backend.conts.ContsKey;
import com.thnakrean.backend.dto.CourseDto;
import com.thnakrean.backend.dto.CoursePageDto;
import com.thnakrean.backend.dto.LectureDto;
import com.thnakrean.backend.dto.PostCourse;
import com.thnakrean.backend.entities.Category;
import com.thnakrean.backend.entities.Course;
import com.thnakrean.backend.entities.CourseLanguage;
import com.thnakrean.backend.entities.Lecture;
import com.thnakrean.backend.exception.ResourceNotFoundException;
import com.thnakrean.backend.mapper.CourseMapper;
import com.thnakrean.backend.mapper.LectureMapper;
import com.thnakrean.backend.mapper.PostMapper;
import com.thnakrean.backend.repository.CourseRepository;
import com.thnakrean.backend.repository.LectureRepository;
import com.thnakrean.backend.repository.VideoRepository;
import com.thnakrean.backend.service.CourseService;
import com.thnakrean.backend.spec.CourseSpec;
import com.thnakrean.backend.spec.filter.CourseFilter;
import com.thnakrean.backend.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final LectureRepository lectureRepository;
    private final VideoRepository videoRepository;

/*
   get all course with Map<String,String> params
   we can filter with Id , Category, Title
   we can set pageSize, PageIndex
   and response with Pagination
 */
    @Override
    public CoursePageDto getAllCourse(Map<String, String> params) {
//      create courseFilter for filter
        CourseFilter courseFilter = new CourseFilter();
//      add Id to courseFilter
        if(params.containsKey(ContsKey.ID)){
            String id = params.get(ContsKey.ID);
            courseFilter.setId(Integer.parseInt(id));
        }
//      add Category to courseFilter
        if(params.containsKey(ContsKey.CATEGORY)){
            String category = params.get(ContsKey.CATEGORY);
            courseFilter.setCategoryId(Integer.parseInt(category));
            System.out.println("CategoryId : " +category);
        }
//      add Title to courseFilter
        if(params.containsKey(ContsKey.TITLE)){
            String title = params.get(ContsKey.TITLE);
            courseFilter.setTitle(title);
        }
//      initialize default value to pageNumber
        int pageNumber= PageUtil.DEFAULT_PAGE_NUMBER;
//      add PageNumber from Map params to PageNumber
        if(params.containsKey(PageUtil.PAGE_NUMBER)){
            String pageNum=params.get(PageUtil.PAGE_NUMBER);
            pageNumber=Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
        }
//      initialize default value to pageSize
        int pageSize=PageUtil.DEFAULT_PAGE_SIZE;
//      add PageSize from Map params to PageSize
        if(params.containsKey(PageUtil.PAGE_LIMIT)){
            pageSize=Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
        }
//      courseSpec in class that  implement Specification to Criteria builder
        CourseSpec courseSpec =new CourseSpec(courseFilter);
//
//      get pageable from pageUtil with pageNumber and pageSize
        Pageable pageable = PageUtil.getPageable(pageNumber,pageSize);

//      findAll(courseSpec , pageable) is from JpaSpecification
        Page<Course> coursePage = courseRepository.findAll(courseSpec, pageable);
//      covert Page<Course> to CoursePageDto
        CoursePageDto coursePageDto = new CoursePageDto(coursePage);

        return coursePageDto;
    }
    @Override
    public CourseDto getCourseById(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course ", id));
        CourseDto courseDto = CourseMapper.INSTANCE.toCourseDto(course);
        List<Lecture> listLecture = lectureRepository.findLecturesByCourseId(id);
        List<LectureDto> lectureDtoList = listLecture.stream().map(lecture -> LectureMapper.INSTANCE.toLectureDtoDto(lecture))
                .collect(Collectors.toList());
        lectureDtoList.forEach(lecture -> {
            videoRepository.findByLectureId(lecture.getId()).stream().forEach(video -> {
                lecture.addVideo(video);
            });
            courseDto.addLecture(lecture);
        });
        return courseDto;
    }
    

    @Override
    @Transactional
    public void createCourse(PostCourse postCourse) {
        Course course = PostMapper.INSTANCE.toCourse(postCourse);
        System.out.println("Course : "+course);
        List<LectureDto> lecturesDto = postCourse.getLecturesDto();
        lecturesDto.stream().forEach(lectureDto -> {
            System.out.println("Lecture Dto: "+lectureDto);
            Lecture lecture=LectureMapper.INSTANCE.toLecture(lectureDto);
            lectureDto.getVideos().forEach(video -> {
                lecture.addVideo(video);
                System.out.println("Video : "+ video);
                videoRepository.save(video);
            });
            course.addLecture(lecture);
            System.out.println("Lecture : "+ lecture);
        });
    }

	@Override
	public CourseDto updateCourseById(CourseDto courseDto, Integer id) {
		Course course = courseRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("course", id));
		System.out.println("Before"+course);
		course = CourseMapper.INSTANCE.toCourse(courseDto);
		course.setId(id);
		System.out.println("After: "+course);
		courseRepository.save(course);
		return CourseMapper.INSTANCE.toCourseDto(course);
	}

    @Override
    public void deleteCourseById(Integer courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course ", courseId)
        );
        courseRepository.delete(course);
    }
}
