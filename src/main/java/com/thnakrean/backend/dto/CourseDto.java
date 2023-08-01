package com.thnakrean.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import com.thnakrean.backend.entities.Category;
import com.thnakrean.backend.entities.CourseLanguage;
import com.thnakrean.backend.entities.CourseLevel;

import lombok.Data;

@Data
public class CourseDto {
    private Integer id;
    private String title;
    private String shortDescription;
    private String courseDescription;
    private String badgeSeller;
    private Integer viewCount;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Boolean enabled;
    private BigDecimal cost;
    private BigDecimal price;
    private Boolean isFree;
    private Integer discountPercent;
    private String imageUrl;
    private String videoUrl;
    private Category category;
    private String requirement;
    private CourseLevel courseLevel;
    private CourseLanguage courseLanguage;
    private Set<CurriculumDto> curriculum;
    private Integer reviewCount;
    private Long averageRating;
}
