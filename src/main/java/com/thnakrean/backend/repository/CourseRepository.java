package com.thnakrean.backend.repository;

import com.thnakrean.backend.entities.Course;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>, JpaSpecificationExecutor<Course> {
	List<Course> findCoursesByCategoryId(Integer id);
}
