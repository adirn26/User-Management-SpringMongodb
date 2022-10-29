package com.usercrud.Usermanagement.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.usercrud.Usermanagement.exception.UserException;
import com.usercrud.Usermanagement.model.User;

public interface UserService {

	public void createUser(User user) throws ConstraintViolationException,UserException;
	
	public List<User> getAlltodos();
	
	public User getSingleUser(int id) throws UserException;
	
	public void updateUser(int id, User user) throws UserException;
	
	public void deleteUserById(int id) throws UserException;
}
