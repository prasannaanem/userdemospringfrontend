package com.userdemo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdemo.dto.UserDto;
import com.userdemo.entity.User;
import com.userdemo.exceptions.ResourceNotFoundException;
import com.userdemo.mapper.UserMapper;
import com.userdemo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = UserMapper.mapToUser(userDto);
		User saveUser = userRepository.save(user);
		
		return UserMapper.mapToUserDto(saveUser);
	}

	@Override
	public UserDto getUserById(Long id) {
		User userId =userRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("User NOt fou with Given Id "+ id));

		return UserMapper.mapToUserDto(userId);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		
		return users.stream().map((user) -> UserMapper.mapToUserDto(user))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(Long id, UserDto userDto) {

		User users = userRepository.findById(id).orElseThrow(
				
				()-> new ResourceNotFoundException("User Not Found In The Given " +id));
				
		        
		 users.setName(userDto.getName());
		 users.setEmail(userDto.getEmail());
		 users.setPlace(userDto.getPlace());
		User updateUser =  userRepository.save(users);
		return UserMapper.mapToUserDto(updateUser);
	}

	@Override
	public String deleteUser(Long id) {
		
		User UserId = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Is Not Exists with Given id :"+id));
          userRepository.deleteById(id);
		
		return "SuccessFully Delated Your id: "+ id;
	}

	
	
	
}



