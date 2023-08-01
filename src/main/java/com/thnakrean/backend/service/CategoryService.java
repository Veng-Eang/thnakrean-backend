package com.thnakrean.backend.service;

import java.util.List;

import com.thnakrean.backend.entities.Category;

public interface CategoryService {
	List<Category> getAllCategory();
	void saveCategory(Category category);
	void updateCategory(Category categoryUpdate,Integer id);
}
