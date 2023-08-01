package com.thnakrean.backend.entities;

import javax.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Boolean freePreview;
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;
    
    @OneToMany(mappedBy = "lecture")
    private Set<Video> video;
    
    @OneToMany(mappedBy = "lecture")
    private Set<Attachment> attachments;
}
