package com.masai.Dto;

import lombok.Data;

@Data
public class JwtAuthRequest {

	
	private String username;//email
	
	private String password;
}
