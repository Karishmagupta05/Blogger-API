package com.masai.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Dto.CategoryDto;
import com.masai.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	
	
	
	@Autowired
	private CategoryService cService;
	
	//create-->>POST
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createUser(@RequestBody CategoryDto categoryDto){
		
		
		CategoryDto create=this.cService.createCategory(categoryDto);
		
	       	return new ResponseEntity<>(create,HttpStatus.CREATED) ;
		
	}
	
	 //update-->> PUT
	 
	 @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable("CategoryId")Integer cid){
	
		 CategoryDto update=this.cService.updateCategory(categoryDto, cid);
	
	        return ResponseEntity.ok(update);
	
	
   }
	
	
	//delete-->>DELETE
	 
	  @DeleteMapping("/{userId}")
	     public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
		  
		  this.cService.deleteCategory(categoryId);
		  
		  return new ResponseEntity(Map.of("message","category deleted successfully"),HttpStatus.OK);
		  
	  }
	
		 //get all user-->>GET
		 
		@GetMapping("/")
		public ResponseEntity<List<CategoryDto>> getAllCategory(){
			
			return ResponseEntity.ok(this.cService.getAllCategories());
		}
		
		
		
		
		 //get user by id-->>GET
		 
			@GetMapping("/{CategoryId}")
			public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer cId){
				
				return ResponseEntity.ok(this.cService.getCategoryById(cId));
			}
	
			
			
			
}
