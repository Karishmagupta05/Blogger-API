package com.masai.service;

import java.util.List;

import com.masai.Dto.UserDto;

public interface UserService {

	
	UserDto createUser(UserDto user);
	
	void deleteUser(Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	UserDto updateUser(UserDto userDto,Integer userId);
	
}
