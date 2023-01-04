package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.category;


@Repository
public interface CategoryRepo extends JpaRepository<category,Integer>{

}
