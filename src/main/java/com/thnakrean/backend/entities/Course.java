package com.thnakrean.backend.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
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
    @CreationTimestamp
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    @UpdateTimestamp
    private LocalDateTime updatedTime;

    private Boolean enabled;

    private BigDecimal cost;

    private BigDecimal price;

    @Column(name = "is_free")
    private Boolean isFree;

    @Column(name = "discount_percent")
    private Integer discountPercent;

    private String requirement;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "video_url", nullable = false)
    private String videoUrl;
    private Integer reviewCount;
    private Long averageRating;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="course_language_id")
    private CourseLanguage courseLanguage;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Lecture>  lectures=new HashSet<>();

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getBadgeSeller() {
        return badgeSeller;
    }

    public void setBadgeSeller(String badgeSeller) {
        this.badgeSeller = badgeSeller;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Long getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Long averageRating) {
        this.averageRating = averageRating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CourseLanguage getCourseLanguage() {
        return courseLanguage;
    }

    public void setCourseLanguage(CourseLanguage courseLanguage) {
        this.courseLanguage = courseLanguage;
    }


    public void addLecture(Lecture lecture){
        if(lecture!=null){
            if(lectures==null){
                lectures=new HashSet<>();
            }
            lectures.add(lecture);
            lecture.setCourse(this);
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", badgeSeller='" + badgeSeller + '\'' +
                ", viewCount=" + viewCount +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", enabled=" + enabled +
                ", cost=" + cost +
                ", price=" + price +
                ", isFree=" + isFree +
                ", discountPercent=" + discountPercent +
                ", requirement='" + requirement + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", reviewCount=" + reviewCount +
                ", averageRating=" + averageRating +
                ", category=" + category +
                ", courseLanguage=" + courseLanguage +
                '}';
    }
}
