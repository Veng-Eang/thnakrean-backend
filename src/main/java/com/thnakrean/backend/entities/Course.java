package com.thnakrean.backend.entities;

import javax.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@Table(name = "course")
public class Course{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = true, length = 255, nullable = false)
    private String title;

    @Column(length = 512, nullable = false, name = "short_description")
    private String shortDescription;

    @Column(length = 4096, nullable = false, name = "course_description")
    private String courseDescription;

    @Column(name = "badge_seller")
    private String badgeSeller;

    @Column(name = "view_count")
    private Integer viewCount;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    private Boolean enabled;

    private BigDecimal cost;

    private BigDecimal price;

    private Boolean isFree;

    @Column(name = "discount_percent")
    private Integer discountPercent;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "video_url", nullable = false)
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String requirement;

    @ManyToOne
    @JoinColumn(name = "course_level_id")
    private CourseLevel courseLevel;

    @OneToMany(mappedBy = "course")
    private Set<Curriculum> curriculum=new HashSet<>();

    @ManyToOne
    private CourseLanguage courseLanguage;

    private Integer reviewCount;

    private Long averageRating;

}
