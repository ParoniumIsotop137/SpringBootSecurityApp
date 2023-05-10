package com.ferenc.securityapp.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ferenc.securityapp.config.JWTService;
import com.ferenc.securityapp.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private JWTService jwtService;

	public AuthenticationResponse register(RegisterRequest request) {
		
		
		   
		return null;
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		
		
		return null;
	}

}
