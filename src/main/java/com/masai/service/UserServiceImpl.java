package com.masai.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dto.UserDto;
import com.masai.exception.NotFoundException;
import com.masai.model.User;
import com.masai.repository.UserRepo;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;  
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	
	

//   private User dtoToUser(UserDto userDto) {
//	
//	User user=new User();
//	user.setId(userDto.getId());
//	user.setName(userDto.getName());
//	user.setEmail(userDto.getEmail());
//	user.setAbout(userDto.getAbout());
//	user.setPassword(userDto.getPassword());
//	return user;	
//
//		
//		
//	}

//	private UserDto userToDto(User user) {
//		
//	UserDto userDto=new UserDto();
//	userDto.setId(user.getId());
//	userDto.setName(user.getName());
//	userDto.setEmail(user.getEmail());
//	userDto.setAbout(user.getAbout());
//	userDto.setPassword(user.getPassword());
	
//	return userDto;	
//	}

	private User dtoToUser(UserDto userDto) {
		//userDto convert into user 
		User user=this.modelMapper.map(userDto, User.class);

		return user;
		
		
		
	}
	
	private UserDto userToDto(User user) {
		//user convert into userDto 
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
	
		return userDto;
	}
	
	
	
	
	
	
	//create-->>
	
	@Override
	public UserDto createUser(UserDto userDto) {
		

		User user=this.dtoToUser(userDto);       //convert
		User savedUser=this.userRepo.save(user); //add in repo
		return this.userToDto(savedUser);        //again convert
	}
	
	//delete-->>

	@Override
	public void deleteUser(Integer userId) {
		
		User user=this.userRepo.findById(userId)  //get
				.orElseThrow(()-> new NotFoundException("User","id",userId)); //custom exception
		
		this.userRepo.delete(user);  //delete from repo
	}

	
	
	//get user by id-->>
	
	@Override
	public UserDto getUserById(Integer userId) {
		
		User user=this.userRepo.findById(userId).  //get
				orElseThrow(()->new NotFoundException("User","id",userId)); //custom exception
		
		return this.userToDto(user); //convert to dto
	}

	
	
	
	//get all user-->>
	
	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users=this.userRepo.findAll();  //get all user data in list
		List<UserDto> userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList()); //list of user convert into list of dto 
		
		return userDtos;
	}

	
	
	
	//update-->>
	
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user=this.userRepo.findById(userId)         //get
				.orElseThrow(()-> new NotFoundException("User","id",userId));  //custom exception
		
		
		user.setName(userDto.getName());            //set
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		
		User updateuser=this.userRepo.save(user);      //update add
		
		UserDto dto=this.userToDto(updateuser);         //convert to dto
		
		
		return dto;
	
		}
	
	
	

	
	

}
