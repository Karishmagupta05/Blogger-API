package com.masai.Dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.masai.model.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {


	private Integer postId;
	
	private String title;
	private String description;
	private String imageName;
	private Date addedDate;
	
	
//	private category category;     //in-loop
//    private User user;             
	
	
	
	   //to avoid loop use dto
		private CategoryDto category;     
        private UserDto user; 
        
        
        private Set<CommentDto> comments=new HashSet<>();
}
