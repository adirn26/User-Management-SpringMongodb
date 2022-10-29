package com.usercrud.Usermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	private int id;
	
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
