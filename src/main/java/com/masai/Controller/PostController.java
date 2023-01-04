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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Dto.PostDto;
import com.masai.Dto.PostResponse;
import com.masai.Dto.UserDto;
import com.masai.constant.Constant;
import com.masai.model.Post;
import com.masai.service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	
	@Autowired
	private PostService postService;
	
	
	
	
//	create post-->>
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId){
		
		
		PostDto create=this.postService.createPost(postDto, userId,categoryId);
		
		return new ResponseEntity<PostDto>(create,HttpStatus.CREATED) ;
		
		
		
	}
	
	
	
//	get by user-->>
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		
		
		List<PostDto> posts=this.postService.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK) ;
		
		
		
	}
	
	
	
	
//	get by category-->>
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
		
		
		List<PostDto> posts=this.postService.getPostByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK) ;
		
		
		
	}
	
	
	
	//get post by id-->>
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		
		PostDto posts=this.postService.getPostById(postId);
		
		return new ResponseEntity<PostDto>(posts,HttpStatus.OK) ;
		
	}
	
	
	
	
	
	
	
	//get all post
	
//	@GetMapping("/posts")
//	public ResponseEntity<List<PostDto>> getAllPost(){
//		
//		List<PostDto> posts=this.postService.getAllPost();
//		
//		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK) ;
//		
//	}
	
//-----------------------------------	
	
	
	
	//pagesize + pagenumber
	//sorting by any one field
	// hhtp://localhost:8089/posts?pagesize=5&pageno=2&sortby=title
	


	//get all post 
	//pagination
	
//	@GetMapping("/posts")
//	public ResponseEntity<List<PostDto>> getAllPost(
//			@RequestParam(value="pageNumber",defaultValue="0",required=false)Integer pageNumber,
//			@RequestParam(value="pageSize",defaultValue="3",required=false)Integer pageSize
//			){
//		
//		List<PostDto> posts=this.postService.getAllPost(pageNumber,pageSize);
//		
//		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK) ;
//		
//	}
	
	//------------------------------
	
//	@GetMapping("/posts")
//	public ResponseEntity<List<PostDto>> getAllPost(
//			@RequestParam(value="pageNumber",defaultValue="0",required=false)Integer pageNumber,
//			@RequestParam(value="pageSize",defaultValue="3",required=false)Integer pageSize
//			){
//		
//		List<PostDto> posts=this.postService.getAllPost(pageNumber,pageSize);
//		
//		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK) ;
//		
//	}
	
	
	
	//-----------------------------
	
	
	//use PostResponse-->>
//	@GetMapping("/posts")
//	public ResponseEntity<PostResponse> getAllPost(
//			@RequestParam(value="pageNumber",defaultValue="0",required=false)Integer pageNumber,
//			@RequestParam(value="pageSize",defaultValue="3",required=false)Integer pageSize
//			){
//		
//		PostResponse posts=this.postService.getAllPost(pageNumber,pageSize);
//		
//		return new ResponseEntity<PostResponse>(posts,HttpStatus.OK) ;
//		
//	}
//-----------------------------
	
	
	
	
	
	//pagesize + pagenumber
	//sorting by any one field
	// hhtp://localhost:8089/posts?pagesize=5&pageno=2&sortby=title
		
//	@GetMapping("/posts")
//	public ResponseEntity<PostResponse> getAllPost(
//			@RequestParam(value="pageNumber",defaultValue="0",required=false)Integer pageNumber,
//			@RequestParam(value="pageSize",defaultValue="3",required=false)Integer pageSize,
//			@RequestParam(value="sortBy",defaultValue="postId",required=false)String sortBy
//			){
//		
//		PostResponse posts=this.postService.getAllPost(pageNumber,pageSize,sortBy);
//		
//		return new ResponseEntity<PostResponse>(posts,HttpStatus.OK) ;
//		
//	}
	
	//------------------------------
	//ACS  DES
	
//	@GetMapping("/posts")
//	public ResponseEntity<PostResponse> getAllPost(
//			@RequestParam(value="pageNumber",defaultValue="0",required=false)Integer pageNumber,
//			@RequestParam(value="pageSize",defaultValue="3",required=false)Integer pageSize,
//			@RequestParam(value="sortBy",defaultValue="postId",required=false)String sortBy,
//			@RequestParam(value="sortDir",defaultValue="asc",required=false)String sortDir
//			){
//		
//		PostResponse posts=this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
//		
//		return new ResponseEntity<PostResponse>(posts,HttpStatus.OK) ;
//		
//	}
	
	
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value="pageNumber",defaultValue=Constant.PAGE_NUMBER,required=false)Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue=Constant.PAGE_SIZE,required=false)Integer pageSize,
			@RequestParam(value="sortBy",defaultValue=Constant.SORT_BY,required=false)String sortBy,
			@RequestParam(value="sortDir",defaultValue=Constant.SORT_DIR,required=false)String sortDir
			){
		
		PostResponse posts=this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		
		return new ResponseEntity<PostResponse>(posts,HttpStatus.OK) ;
		
	}
	
	
	//delete
	
	@DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable("postId") Integer postId) {
	  
	  this.postService.deletePost(postId);
	  
	  return new ResponseEntity(Map.of("message","post deleted successfully"),HttpStatus.OK);
	  
 }
	
	
	
//	//update
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
		
		PostDto posts=this.postService.updatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(posts,HttpStatus.OK) ;
		
	}
	
	
	//search
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords")String key){
		
		List<PostDto> posts=this.postService.SearchPost(key);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK) ;
	}
	
	
}
