package com.thnakrean.backend.entities;

import javax.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Boolean freePreview;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "lecture",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Video> videos;

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

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }
    public void addVideo(Video video){
        if(video!=null){
            if(videos==null){
                videos = new HashSet<>();
            }
            videos.add(video);
            video.setLecture(this);
        }
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", freePreview=" + freePreview +
                ", course=" + course +
                '}';
    }
}
