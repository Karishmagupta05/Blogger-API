package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.Dto.CategoryDto;


public interface CategoryService {

	
	
	
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	void deleteCategory(Integer categoryId);
	
	CategoryDto getCategoryById(Integer categoryId);
	
	List<CategoryDto> getAllCategories();
	
	CategoryDto updateCategory(CategoryDto categoryDto,Integer CategoryId);
}
