package com.thnakrean.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thnakrean.backend.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
