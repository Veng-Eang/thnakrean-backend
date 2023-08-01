package com.thnakrean.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class VideoDto {
    private Integer id;
    private String videoUrl;
    private Integer timeHH;
    private Integer timeMM;
    private Integer timeSS;
    @JsonIgnore
    private LectureDto lecture;
}
