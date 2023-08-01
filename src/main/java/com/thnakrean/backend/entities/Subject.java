package com.thnakrean.backend.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
}
