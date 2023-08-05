package com.thnakrean.backend.entities;

import javax.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Course> courses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
