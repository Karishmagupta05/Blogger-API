package com.masai.service;

import java.util.List;

import com.masai.Dto.PostDto;
import com.masai.Dto.PostResponse;
import com.masai.model.Post;

public interface PostService {

	
	//create post
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	
	//delete post
	void deletePost(Integer postId);
	
	
//	//get all Post
//	List<PostDto> getAllPost(Integer pageNumber,Integer pageSize);
	
	//get all Post
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
		
		
	//get post by id
	PostDto getPostById(Integer postId);
	
	
	//update post
	PostDto updatePost(PostDto postDto,Integer postId);

	
	//get all post by user
	List<PostDto> getPostByUser(Integer userId);
	
	
	
	//get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	
	
	//search post
	List<PostDto> SearchPost(String Keyword);
}
