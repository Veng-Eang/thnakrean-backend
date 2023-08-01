package com.thnakrean.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thnakrean.backend.entities.Lecture;
import com.thnakrean.backend.entities.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>{
	List<Video> findByLectureId(Integer lectureId);
}
