package com.thnakrean.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thnakrean.backend.entities.Lecture;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Integer> {
    List<Lecture> findLecturesByCourseId(Integer courseId);
}
