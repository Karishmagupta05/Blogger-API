//package com.masai.security;
//
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.masai.exception.NotFoundException;
//import com.masai.repository.UserRepo;
//
//
//@Service
//public class CustomUserDetailService implements UserDetailsService{
//
//	
//	@Autowired
//	private UserRepo uRepo;
//	
//	
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//
//		//loading user from DB by username
//	com.masai.model.User u=	this.uRepo.findByEmail(username).orElseThrow(()->new NotFoundException("User","email",0));
//		
//		return u;
//	}
//
//}
