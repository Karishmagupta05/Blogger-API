package com.masai.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException{
	

	String Resourcename;
	String fieldName;
	long fieldValue;
	
	
	public NotFoundException(String resourcename, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s",resourcename,fieldName,fieldValue));
		Resourcename = resourcename;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
	
	
	
	
	
	
}
