package com.masai.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer postId;
	
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String description;

	private String imageName;
	
	private Date addedDate;
	
	
	@ManyToOne
	private category category;
	
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	private Set<Comment> comments=new HashSet<>();
	
	
	
	
	
}
