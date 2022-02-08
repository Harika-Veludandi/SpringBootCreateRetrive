package com.capgemini.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.capgemini.dto.UserDto;
import com.capgemini.entities.User;



@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserDto convertToDto(User user);
	User convertToEntity(UserDto userDto);
	List<UserDto> toDtoList(List<User> users);
	List<User> fromDtoList(List<UserDto> usersDto);
	

}
