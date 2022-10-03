package com.usercrud.Usermanagement.exception;

public class UserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserException(String message){
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "User with "+id+" Not found!";
	}
	
	public static String UserAlreadyExists() {
		return "User with given name already exists";
	}
	
	public static String EmailAlreadyExists() { 
		return "User with the given email already exists";
	}
	
}
