package com.thnakrean.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thnakrean.backend.entities.Category;
import com.thnakrean.backend.exception.ResourceNotFoundException;
import com.thnakrean.backend.repository.CategoryRepository;
import com.thnakrean.backend.service.CategoryService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
	private final CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
		
	}

	@Override
	public void saveCategory(Category category) {
		categoryRepository.save(category);
		
	}

	@Override
	public void updateCategory(Category categoryUpdate, Integer id) {
		Category category = categoryRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Category", id));
		category.setName(categoryUpdate.getName());
		categoryRepository.save(category);
	}

}
