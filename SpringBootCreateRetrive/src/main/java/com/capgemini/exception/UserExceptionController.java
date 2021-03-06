package com.capgemini.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UserExceptionController{
	
	@ExceptionHandler(value = {UserNotFoundException.class})
	public ResponseEntity<Object> handleAnyException(UserNotFoundException ex)
	{
		return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
	}
}
