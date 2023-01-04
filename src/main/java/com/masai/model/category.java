package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="categories")
public class category {

	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer categoryId;
	
	@Column(name="category_Title")
	private  String categoryTitle;
	
	@Column(name="category_Description")
	private  String categoryDescription;

	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
    private List<Post> posts=new ArrayList<>();     	//one category multiple post
	

	

}
