package com.usercrud.Usermanagement.advice;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.usercrud.Usermanagement.exception.UserException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleContraintViolation(ConstraintViolationException e){		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<?> handleUserException(UserException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	}
	
	
}
