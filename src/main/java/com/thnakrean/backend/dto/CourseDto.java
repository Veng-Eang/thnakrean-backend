package com.thnakrean.backend.dto;

import com.thnakrean.backend.entities.Category;
import com.thnakrean.backend.entities.CourseLanguage;
import com.thnakrean.backend.entities.Lecture;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private CourseLanguage courseLanguage;
    private Integer reviewCount;
    private Long averageRating;
    private List<LectureDto> lecturesDto=new ArrayList<>();

    public void addLecture(LectureDto lectureDto){
        if(lectureDto!=null){
            if(lecturesDto==null){
                lecturesDto=new ArrayList<>();
            }
            lecturesDto.add(lectureDto);
        }
    }
}
