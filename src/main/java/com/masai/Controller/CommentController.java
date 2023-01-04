package com.masai.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Dto.CommentDto;
import com.masai.Dto.PostDto;
import com.masai.model.Comment;
import com.masai.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

	
	
	
	@Autowired
	private CommentService cService;
	
	
	
//	create post-->>
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer postId){
		
		
		CommentDto create=this.cService.createComment(commentDto, postId);
		
		return new ResponseEntity<CommentDto>(create,HttpStatus.CREATED) ;
		
		
		
	}
	
	
	
	//delete
	
		@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<CommentDto> deleteComment(@PathVariable Integer commentId){
		
		
		this.cService.deleteComment(commentId);
		
		  return new ResponseEntity(Map.of("message","comment deleted successfully"),HttpStatus.OK);
		
		
		
	}
	
}
