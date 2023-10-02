package com.backend.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

 /* if id not found in controller then this will help to give warning 
  *  (id not found)*/
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public String HandleResourcerNotFoundException(ResourceNotFoundException ex) {
	
		return ex.getMessage();
	}
}
