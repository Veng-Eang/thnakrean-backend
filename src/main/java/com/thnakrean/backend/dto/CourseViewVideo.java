package com.thnakrean.backend.dto;

import com.thnakrean.backend.entities.Lecture;

import java.util.ArrayList;
import java.util.List;

public class CourseViewVideo {
    private List<Lecture> lectures;

    public List<Lecture> getLectures() {
        return lectures;
    }
    public void addLecture(Lecture lecture){
        if(lecture!=null){
            if(lectures==null){
                lectures=new ArrayList<>();
            }
            lectures.add(lecture);
        }
    }
}
