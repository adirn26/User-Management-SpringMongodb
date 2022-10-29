package com.usercrud.Usermanagement.service;

import com.usercrud.Usermanagement.exception.UserException;
import com.usercrud.Usermanagement.model.User;
import com.usercrud.Usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	
//	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repo;

	@Autowired
	private SequenceGenerator seqservice;
	
	@Override
	public void createUser(User user) throws ConstraintViolationException,UserException{
		// TODO Auto-generated method stub
		Optional<User> useroptional =  repo.findByUser(user.getUsername());
		Optional<User> emailoptional =  repo.findByEmail(user.getEmail());
		if(useroptional.isPresent()) {
			throw new UserException(UserException.UserAlreadyExists());
		}
		else if(emailoptional.isPresent()) {
			throw new UserException(UserException.EmailAlreadyExists());
		}
		else {
			user.setCreatedAt(new Date(System.currentTimeMillis()));
			user.setId(seqservice.getSequenceNum(User.SEQUENCE_NAME));
			repo.save(user);
		}
	}

	@Override
	public List<User> getAlltodos() {
		List<User> users = repo.findAll();
		if(users.size()>0) {
			return users;
		}
		else {
			return new ArrayList<User>();
		}
	}

	@Override
	public User getSingleUser(int id) throws UserException {
		Optional<User> useroptional = repo.findById(id);
		if(!useroptional.isPresent()) {
			throw new UserException(UserException.NotFoundException(id));
		}
		else {
			return useroptional.get();
		}
	}

	@Override
	public void updateUser(int id, User user) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> useroptional = repo.findById(id);
		Optional<User> sameusername = repo.findByUser(user.getUsername());
		Optional<User> sameemail = repo.findByEmail(user.getEmail());
		if(useroptional.isPresent()) {
			if(sameusername.isPresent() && sameusername.get().getId()!=id) {
				throw new UserException(UserException.UserAlreadyExists());
			}
			if(sameemail.isPresent() && sameemail.get().getId()!=id) {
				throw new UserException(UserException.EmailAlreadyExists());
			}
			User upUser = useroptional.get();
			if(user.getEmail()!=null)
			upUser.setEmail(user.getEmail());
			if(user.getUsername()!=null)
			upUser.setUsername(user.getUsername());
			if(user.getPassword()!=null)
			upUser.setPassword(user.getPassword());
			upUser.setUpdatedAt(new Date(System.currentTimeMillis()));
			repo.save(upUser);
		}else {
			throw new UserException(UserException.NotFoundException(id));
		}
	}

	@Override
	public void deleteUserById(int id) throws UserException {
		Optional<User> useroptional = repo.findById(id);
		if(useroptional.isPresent()) {
			repo.deleteById(id);
		} else {
			throw new UserException(UserException.NotFoundException(id));
		}
		
	}

}
