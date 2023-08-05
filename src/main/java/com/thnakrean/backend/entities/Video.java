package com.thnakrean.backend.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String videoUrl;

    private Integer timeHH;

    private Integer timeMM;

    private Integer timeSS;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    @JsonBackReference
    private Lecture lecture;

    public Lecture getLecture() {
        return lecture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getTimeHH() {
        return timeHH;
    }

    public void setTimeHH(Integer timeHH) {
        this.timeHH = timeHH;
    }

    public Integer getTimeMM() {
        return timeMM;
    }

    public void setTimeMM(Integer timeMM) {
        this.timeMM = timeMM;
    }

    public Integer getTimeSS() {
        return timeSS;
    }

    public void setTimeSS(Integer timeSS) {
        this.timeSS = timeSS;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", videoUrl='" + videoUrl + '\'' +
                ", timeHH=" + timeHH +
                ", timeMM=" + timeMM +
                ", timeSS=" + timeSS +
                ", lecture=" + lecture +
                '}';
    }
}
