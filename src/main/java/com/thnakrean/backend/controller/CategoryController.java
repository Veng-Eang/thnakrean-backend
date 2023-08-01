package com.thnakrean.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thnakrean.backend.entities.Category;
import com.thnakrean.backend.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/categories")
public class CategoryController {
	private final CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<?> createNewCategory(@RequestBody Category category){
		categoryService.saveCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body("Create Category Successfully.");
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> categories = categoryService.getAllCategory();
		return ResponseEntity.ok(categories);
	}
	@PutMapping("{id}")
	public ResponseEntity<?> updateCategory(@RequestBody Category category,
											@PathVariable("id") Integer id){
		categoryService.updateCategory(category, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
								.body("Update Category Successfully.");
	}

}
