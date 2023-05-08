package com.ferenc.securityapp.user;

import lombok.Data;

@Data
public class User {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	
}
