package com.thnakrean.backend.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thnakrean.backend.entities.Attachment;
import com.thnakrean.backend.entities.Curriculum;
import com.thnakrean.backend.entities.Video;

import lombok.Data;

@Data
public class LectureDto {
	private Integer id;
    private String title;
    private String description;
    private Boolean freePreview;
    @JsonIgnore
    private Curriculum curriculum;
    private Set<VideoDto> video;
    private Set<Attachment> attachments;
}
