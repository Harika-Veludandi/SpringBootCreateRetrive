package com.capgemini;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.entities.User;
import com.capgemini.repository.UserRepository;
import com.capgemini.service.UserService;

@SpringBootTest
class SpringBootCreateRetriveApplicationTests {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void getAllUsersTest()
	{
		when(userRepository.findAll()).thenReturn(Stream.of(new User(15,"neha",13,56000),new User(159,"Ooha",16,65000)).collect(Collectors.toList()));
		assertEquals(2,userService.getAllUsers().size());
	}
	
//	@Test
//	public void getUserByIdTest()
//	{
//		Integer id = 123;
//		when(userRepository.findById(id)).thenReturn(Optional.empty());
//		assertEquals(1,((List<User>) userService.getUserById(id)).size());
//	}

	@Test
	void contextLoads() {
		
	}

}
