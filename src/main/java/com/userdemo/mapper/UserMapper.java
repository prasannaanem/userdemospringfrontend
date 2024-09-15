package com.userdemo.mapper;

import com.userdemo.dto.UserDto;
import com.userdemo.entity.User;

public class UserMapper {
	
	
	
	public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPlace(userDto.getPlace());
        return user;
    }
	
	
	
	public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPlace(user.getPlace());
        return userDto;
    }

}
