package com.thnakrean.backend.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
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
    private Lecture lecture;
}
