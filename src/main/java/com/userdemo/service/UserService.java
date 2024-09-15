package com.userdemo.service;

import java.util.List;

import com.userdemo.dto.UserDto;

public interface UserService {
	
	
	
	
	public UserDto createUser(UserDto userDto);
	
	public UserDto getUserById(Long id);
	
	
	public List<UserDto> getAllUsers();
	
	public UserDto updateUser(Long id , UserDto userDto);
	
	public String deleteUser(Long id);

}
