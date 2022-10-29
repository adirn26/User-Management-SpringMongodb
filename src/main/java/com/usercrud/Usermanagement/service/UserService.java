package com.usercrud.Usermanagement.service;

import com.usercrud.Usermanagement.exception.UserException;
import com.usercrud.Usermanagement.model.User;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface UserService {

	public void createUser(User user) throws ConstraintViolationException,UserException;
	
	public List<User> getAlltodos();
	
	public User getSingleUser(String id) throws UserException;
	
	public void updateUser(String id, User user) throws UserException;
	
	public void deleteUserById(String id) throws UserException;
}
