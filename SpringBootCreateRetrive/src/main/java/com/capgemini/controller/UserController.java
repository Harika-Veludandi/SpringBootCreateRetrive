package com.capgemini.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.UserDto;
import com.capgemini.entities.User;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/alluser")
	public List<UserDto> getAllUsers() 
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("/getById/{id}")
	public UserDto getUserById(@PathVariable("id") int userId) 
	{
		boolean isUserExist = userService.isUserExist(userId);
		if(isUserExist)
		{
			return userService.getUserById(userId);
	
		}
		else
		{
			throw new UserNotFoundException();
		}
		
		
	}
	
	@GetMapping("/health/{id}")
	public ResponseEntity<String> healthCheck(@PathVariable int id)
	{
		String error = userService.healthcheck(id);
		logger.info("Health Check Successful");
		return new ResponseEntity<String>(error,HttpStatus.OK);
	}
	
	@PostMapping("/addOrUpdate")
	public UserDto addOrUpdate(@RequestBody User user)
	{
		return userService.addOrUpdate(user);
		
	}
	
	/*
	 * @DeleteMapping("/delete/{id}") public ResponseEntity<UserDto>
	 * deleteuser(@PathVariable("id") int userId) throws Exception { UserDto users =
	 * userService.deleteUser(userId); logger.info("Deleted Succesfully");
	 * 
	 * 
	 * return new ResponseEntity<UserDto>(users,HttpStatus.OK); }
	 */
	
	/*
	 * @GetMapping("/allusers") public ResponseEntity<List<UserDto>> getAllUsers() {
	 * List<UserDto> users = userService.getAllUsers();;
	 * logger.info("Getting the details of all users"); return new
	 * ResponseEntity<List<UserDto>>(users,HttpStatus.OK); }
	 */
	
	/*
	 * @GetMapping("/getById/{id}") public ResponseEntity<UserDto>
	 * getUserById(@PathVariable("id") int userId) { boolean isUserExist =
	 * userService.isUserExist(userId); if(isUserExist) { UserDto users =
	 * userService.getUserById(userId);
	 * logger.info("Getting the details of particular user"); return new
	 * ResponseEntity<UserDto>(users,HttpStatus.OK); } else { throw new
	 * UserNotFoundException(); }
	 * 
	 * 
	 * }
	 */
	
	/*
	 * @PostMapping("/addOrUpdate") public ResponseEntity<UserDto>
	 * addOrUpdate(@RequestBody User user) { UserDto users =
	 * userService.addOrUpdate(user);; logger.info("User Successfully Added");
	 * return new ResponseEntity<UserDto>(users,HttpStatus.OK);
	 * 
	 * }
	 */
	
	
}
