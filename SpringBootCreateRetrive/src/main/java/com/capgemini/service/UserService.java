package com.capgemini.service;

import java.util.List;

import com.capgemini.dto.UserDto;
import com.capgemini.entities.User;

public interface UserService{
	
	//retrival
	public List<UserDto> getAllUsers();
	public UserDto getUserById(int userId);
	
	//create
	public UserDto addOrUpdate(User user);
	
	
	public String healthcheck(int id);
	public boolean isUserExist(int userId);
	
	//delete
	//public UserDto deleteUser(int userId) throws Exception;
	
	
	

}
 