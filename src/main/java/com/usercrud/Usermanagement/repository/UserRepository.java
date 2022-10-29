package com.usercrud.Usermanagement.repository;

import com.usercrud.Usermanagement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
	
	@Query("{'username': ?0}")
	Optional<User> findByUser(String username);
	
	@Query("{'email': ?0}")
	Optional<User> findByEmail(String email);
}
