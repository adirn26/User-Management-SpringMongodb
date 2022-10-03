package com.usercrud.Usermanagement.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usercrud.Usermanagement.exception.UserException;
import com.usercrud.Usermanagement.model.User;
import com.usercrud.Usermanagement.repository.UserRepository;
import com.usercrud.Usermanagement.service.UserService;


@RestController
public class Controller {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		List<User> users = userService.getAlltodos();
		return new ResponseEntity<>(users, users.size()>0?HttpStatus.OK: HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		try {
//			user.setCreatedAt(new Date(System.currentTimeMillis()));
//			repo.save(user);
			userService.createUser(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch(ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
			
		} catch(UserException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
		
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(userService.getSingleUser(id), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") String id,@RequestBody User user){
		try {
			userService.updateUser(id, user);
			return new ResponseEntity<>("Updated User with id "+id, HttpStatus.OK);
		} catch(ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch(UserException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") String id){
		try {
			userService.deleteUserById(id);
			return new ResponseEntity<>("Succesfully deleted user with id "+id, HttpStatus.OK);
		}
		catch(UserException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
