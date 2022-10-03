package com.usercrud.Usermanagement.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
	
	@Id
	private String id;
	
	@NotNull(message = "username cant be null")
	private String username;
	
	@NotNull(message = "email cant be null")
	private String email;
	
	@NotNull(message = "password cant be null")
	private String password;
	
	private boolean isAdmin;
	
	private Date createdAt;
	
	private Date updatedAt;
}
