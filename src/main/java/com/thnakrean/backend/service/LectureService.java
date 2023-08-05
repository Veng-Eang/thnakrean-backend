package com.thnakrean.backend.service;

import com.thnakrean.backend.dto.CourseViewVideo;
import com.thnakrean.backend.dto.LectureDto;
import com.thnakrean.backend.entities.Lecture;

import java.util.List;

public interface LectureService {
    List<LectureDto> getLectureAndVideoByCourseId(Integer courseId);
}
