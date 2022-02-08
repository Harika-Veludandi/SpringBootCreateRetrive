package com.capgemini.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.dto.UserDto;
import com.capgemini.entities.User;
import com.capgemini.mapper.UserMapper;
import com.capgemini.repository.UserRepository;
import com.capgemini.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper mapper;

	@Override
	public List<UserDto> getAllUsers(){
		logger.info("Getting all users data Successfully");
		List<User> users = userRepository.findAll();
		return mapper.toDtoList(users);
	}

	@Override
	public UserDto getUserById(int userId) {
		logger.info("Getting user by id ");
		User user = userRepository.findById(userId).orElse(null);
		return mapper.convertToDto(user);	}

	@Override
	public UserDto addOrUpdate(User user) {
		logger.info("User Added Successfully");
		User adduser = userRepository.save(user);
		return mapper.convertToDto(adduser);
	}
	
	@Override
	public String healthcheck(int id) {
		logger.info("Shows the Health check status");
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
			return "Health check is success";
		else
			return "Health check is fail";
		
	}
	
	@Override
	public boolean isUserExist(int userId)
	{
		return userRepository.existsById(userId);
	}

	
	/*
	 * @Override public UserDto deleteUser(int userId) throws Exception{ // TODO
	 * Auto-generated method stub User deletedUser = null; try { deletedUser =
	 * userRepository.findById(userId).orElse(null); if(deletedUser == null) { throw
	 * new Exception("User not available"); } else {
	 * userRepository.deleteById(userId); } } catch(Exception e) { throw e; } return
	 * mapper.convertToDto(deletedUser); }
	 */
	

}
