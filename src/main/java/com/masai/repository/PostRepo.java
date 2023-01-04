package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Post;
import com.masai.model.User;
import com.masai.model.category;



@Repository
public interface PostRepo extends JpaRepository<Post,Integer>{

	
	List<Post> findByUser(User user); // get all post from user
	
	List<Post> findByCategory(category category); // get all post from category
	
	
	//search
	List<Post> findByTitleContaining(String title);
}
