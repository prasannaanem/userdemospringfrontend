package com.userdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name should NOt Be Blank")
	@NotEmpty(message = "Name Should NOt Be Empty")
	@NotNull(message = "Name Should Not Be Null")
	private String name;
	
	@Email
	private String email;
	@NotBlank(message = "place should NOt Be Blank")
	@NotEmpty(message = "place Should NOt Be Empty")
	@NotNull(message = "place Should Not Be Null")
	private String place;

}
