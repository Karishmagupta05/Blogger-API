package com.masai.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.Dto.PostDto;
import com.masai.Dto.PostResponse;
import com.masai.exception.NotFoundException;
import com.masai.model.Post;
import com.masai.model.User;
import com.masai.model.category;
import com.masai.repository.CategoryRepo;
import com.masai.repository.PostRepo;
import com.masai.repository.UserRepo;



@Service
public class PostServiceImpl implements PostService{

	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo catRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	
	
	
	//create post-->>
	
	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		
		User user=this.userRepo.findById(userId)   //get user 
				.orElseThrow(()->new NotFoundException("User","id",userId));
		
		
		category cate=this.catRepo.findById(categoryId)   //get category
				.orElseThrow(()->new NotFoundException("Category","id",categoryId));
		
		Post post=this.modelMapper.map(postDto, Post.class);  //convert
		post.setImageName("default.png");                 //set
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(cate);
		
		
		Post p=this.postRepo.save(post);  //save in postRepo
		
		return this.modelMapper.map(p, PostDto.class);//convert
	}

	
	
	
	
	@Override
	public void deletePost(Integer postId) {
		

		Post post=this.postRepo.findById(postId)
		.orElseThrow(()-> new NotFoundException("Post","id",postId));
		
		this.postRepo.delete(post);
		
	}

	
	
	//get all post
	
//	@Override
//	public List<PostDto> getAllPost() {
//	
//	
//
//		List<Post> allPosts=this.postRepo.findAll();
//		
//		List<PostDto> dto=allPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class))
//		                          .collect(Collectors.toList());
//		
//		return dto;
//	}

	//-------------------------
	
	//get all post
	//pagination-->>
	
	@Override
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir) {
	
	
//		Sort sort=null;
//		
//		if(sortDir.equalsIgnoreCase("asc")) {
//			
//			sort=Sort.by(sortBy).ascending();
//		}else {
//			
//			sort=Sort.by(sortBy).descending();
//		}
		
		Sort sort=(sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending());
		
		
	//	Pageable page=PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending()) ; //sorting desc  //pageable object-->>which page no and how much size
	//	Pageable page=PageRequest.of(pageNumber, pageSize, Sort.by(sortBy)) ;
		Pageable page=PageRequest.of(pageNumber, pageSize, sort);
		
		
		Page<Post> pgPost=this.postRepo.findAll(page);  //
		List<Post> allPosts=pgPost.getContent();         //get all  post
	

		//List<Post> allPosts=this.postRepo.findAll();
		
		List<PostDto> dto=allPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class))
		                          .collect(Collectors.toList());
		
		
		
		PostResponse postres=new PostResponse();
		postres.setContent(dto);
		postres.setPageNumber(pgPost.getNumber());
		postres.setPageSize(pgPost.getSize());
		postres.setTotalElements(pgPost.getTotalElements());
		postres.setTotalPages(pgPost.getTotalPages());
		postres.setLastPage(pgPost.isLast());
		
		return postres;
	}

	
	
	//get post by id-->>
	
	@Override
	public PostDto getPostById(Integer postId) {
	
        Post posts=this.postRepo.findById(postId)
            .orElseThrow(()-> new NotFoundException("post","id",postId));
		
		return this.modelMapper.map(posts, PostDto.class);
		
	}

	
	
	
	//update-->>
	
	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		


		Post post=this.postRepo.findById(postId)
		              .orElseThrow(()-> new NotFoundException("Post","id",postId));
		
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setImageName(postDto.getImageName());
		
		Post updatepost=this.postRepo.save(post);
		
		
		return this.modelMapper.map(updatepost, PostDto.class);
		
	}

	
	
	
	
	//get all post by user-->>
	
	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		

		
		User user=this.userRepo.findById(userId)   //get user 
				.orElseThrow(()->new NotFoundException("User","id",userId));
		
	    List<Post> posts=this.postRepo.findByUser(user);  //find all post by category id
		
		List<PostDto> Dto=posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class))
				         .collect(Collectors.toList());     //convert to postDto 
		
		return Dto;
		

	}

	
	
	
	
	//get all post by category-->>
	
	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		

		category cate=this.catRepo.findById(categoryId)   //get category by given category id
				.orElseThrow(()->new NotFoundException("Category","id",categoryId));
		
		
		List<Post> posts=this.postRepo.findByCategory(cate);  //find all post by category id
		
		
		List<PostDto> Dto=posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class))
				         .collect(Collectors.toList());     //convert to postDto 
		
		
		return Dto;
		
	}

	
	
	
	//search-->>
	
	@Override
	public List<PostDto> SearchPost(String Keyword) {
	
        List<Post>posts= this.postRepo.findByTitleContaining(Keyword);
		
        
        List<PostDto> Dto=posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class))
		         .collect(Collectors.toList()); 
        
		return Dto;
	}
	
	
	

}
