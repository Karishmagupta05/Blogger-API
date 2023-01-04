package com.masai.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dto.CommentDto;
import com.masai.exception.NotFoundException;
import com.masai.model.Comment;
import com.masai.model.Post;
import com.masai.repository.CommentRepo;
import com.masai.repository.PostRepo;


@Service
public class CommentServiceImpl implements CommentService{

	
	@Autowired
	private PostRepo postRepo;
	
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		

		Post post=this.postRepo.findById(postId)
		              .orElseThrow(()-> new NotFoundException("Post","id",postId));
		
	    Comment c=	this.modelMapper.map(commentDto, Comment.class);
		
	
	    c.setPost(post);
	    
	    Comment saveComment=this.commentRepo.save(c);
	    
		return this.modelMapper.map(saveComment, CommentDto.class);
		
		
	}

	
	
	@Override
	public void deleteComment(Integer commentId) {
		

		Comment c=this.commentRepo.findById(commentId)
				 .orElseThrow(()-> new NotFoundException("comment","id",commentId));
	
		this.commentRepo.delete(c);
	}

}
