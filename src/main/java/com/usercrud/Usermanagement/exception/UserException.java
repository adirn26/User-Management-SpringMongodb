package com.usercrud.Usermanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserException extends Exception {
	
	private static final Logger logger = LoggerFactory.getLogger(UserException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserException(String message){
		super(message);
	}
	
	public static String NotFoundException(int id) {
		logger.error("User with {} not found", id);
		return "User with "+id+" Not found!";
	}
	
	public static String UserAlreadyExists() {
		logger.error("User with already exists");
		return "User with given name already exists";
	}
	
	public static String EmailAlreadyExists() { 
		logger.error("User with the given email already exists");
		return "User with the given email already exists";
	}
	
}
