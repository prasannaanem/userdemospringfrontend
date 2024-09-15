package com.userdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userdemo.dto.UserDto;
import com.userdemo.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000") 
@RequestMapping("/users")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<UserDto> createUser( @Valid @RequestBody UserDto userDto){
		UserDto saveUser = userService.createUser(userDto);
		return new ResponseEntity<>(saveUser , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/userid/{id}")
	public ResponseEntity<UserDto>  getUserById(@PathVariable Long id){
		
		UserDto userDto = userService.getUserById(id);
		
		return ResponseEntity.ok(userDto);
		
	} 
	
	@GetMapping("/getall")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users =userService.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateuser(@PathVariable Long id , @RequestBody UserDto userDto){
		
		UserDto userDtos = userService.updateUser(id, userDto);
		return ResponseEntity.ok(userDtos);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUserById( @PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("user Deleted successfully ! with given id : "+id);
	}
}
