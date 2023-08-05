package com.thnakrean.backend.dto;

import com.thnakrean.backend.entities.Course;
import com.thnakrean.backend.entities.Video;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LectureDto {
    private Integer id;
    private String title;
    private String description;
    private Boolean freePreview;
    private List<Video> videos;


    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFreePreview() {
        return freePreview;
    }

    public void setFreePreview(Boolean freePreview) {
        this.freePreview = freePreview;
    }

    public void addVideo(Video video){
        if(video!=null){
            if(videos==null){
                videos=new ArrayList<>();
            }
            videos.add(video);
        }
    }

    @Override
    public String toString() {
        return "LectureDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", freePreview=" + freePreview +
                ", videos=" + videos +
                '}';
    }
}
