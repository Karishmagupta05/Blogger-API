package com.masai.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Dto.UserDto;
import com.masai.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	
	
	@Autowired
	private UserService userService;
	
	
	
	//create-->>POST
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		
		
		     UserDto create=this.userService.createUser(userDto);
		
	       	return new ResponseEntity<>(create,HttpStatus.CREATED) ;
		
	}
	
	
	
	//delete-->>DELETE
	
	
     /*
	 @DeleteMapping("/{userId}")
	 public void deleteUser(@PathVariable("userId") int userId) {
		 
	        userService.deleteUser(userId);
	   }
	 
      */
     
  
//	  @PreAuthorize("hasRole('ADMIN')")
//	  @DeleteMapping("/{userId}")
//	     public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId) {
//		  
//		  this.userService.deleteUser(userId);
//		  
//		  return new ResponseEntity(Map.of("message","user deleted successfully"),HttpStatus.OK);
//		  
//	  }
	
	 
	 
	
	 
	 
	 //update-->> PUT
	 
	 @PutMapping("/{userId}")
     public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId")Integer uid){
	
           	UserDto update=this.userService.updateUser(userDto, uid);
	
	        return ResponseEntity.ok(update);
	
	
    }
	
	 
	 //get all user-->>GET
	 
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	
	
	
	 //get user by id-->>GET
	 
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
			
			return ResponseEntity.ok(this.userService.getUserById(userId));
		}
		
	
}
