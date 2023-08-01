package com.thnakrean.backend.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fileUrl;
    @ManyToOne
    private Lecture lecture;
}
