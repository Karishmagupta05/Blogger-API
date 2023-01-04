package com.masai.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dto.CategoryDto;
import com.masai.exception.NotFoundException;

import com.masai.model.category;
import com.masai.repository.CategoryRepo;


@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo cRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		
		category c=this.modelMapper.map(categoryDto, category.class); //convert
		category addc=this.cRepo.save(c);                    //add
		return this.modelMapper.map(c, CategoryDto.class);  //again convert
	}

	
	
	
	@Override
	public void deleteCategory(Integer categoryId) {
		
		category c=this.cRepo.findById(categoryId)  //get
				.orElseThrow(()-> new NotFoundException("category","categoryId",categoryId)); //custom exception
		
		this.cRepo.delete(c);  //delete from repo
		
	}
	
	
	

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		
		category c=this.cRepo.findById(categoryId).  //get
				orElseThrow(()->new NotFoundException("User","id",categoryId)); //custom exception
		
		return this.modelMapper.map(c, CategoryDto.class);//convert to dto
	}

	
	
	
	@Override
	public List<CategoryDto> getAllCategories() {
		
		List<category> c=this.cRepo.findAll();  //get all user data in list
		List<CategoryDto> Dtos=c.stream().map(category->this.modelMapper.map(c, CategoryDto.class)).collect(Collectors.toList()); //list of user convert into list of dto 
		
		return Dtos;
	}

	
	
	
	
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer CategoryId) {
		
		category c=this.cRepo.findById(CategoryId)         //get
				.orElseThrow(()-> new NotFoundException("category","CategoryId",CategoryId));  //custom exception
		
		
		c.setCategoryTitle(categoryDto.getCategoryTitle());            //set
		c.setCategoryDescription(categoryDto.getCategoryDescription());
		
		category updateuser=this.cRepo.save(c);      //update add
		
		CategoryDto dto=this.modelMapper.map(updateuser,CategoryDto.class);         //convert to dto
		
		
		return dto;
	}

}
