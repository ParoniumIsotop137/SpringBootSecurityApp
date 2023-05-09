package com.ferenc.securityapp.auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ferenc.securityapp.config.JWTService;
import com.ferenc.securityapp.user.Role;
import com.ferenc.securityapp.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	UserRepository repo;
	
	PasswordEncoder encoder;
	JWTService jwtService;

	public AuthenticationResponse register(RegisterRequest request) {
		
		
		   
		return null;
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
