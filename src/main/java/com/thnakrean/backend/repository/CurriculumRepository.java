package com.thnakrean.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thnakrean.backend.entities.Course;
import com.thnakrean.backend.entities.Curriculum;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Integer>{
	List<Curriculum> findByCourseId(Integer id);
	List<Curriculum> findByCourse(Course course);
}
