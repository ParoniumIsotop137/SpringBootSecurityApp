package com.ferenc.securityapp.auth;

import com.ferenc.securityapp.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ferenc.securityapp.config.JWTService;
import com.ferenc.securityapp.user.UserRepository;

import lombok.RequiredArgsConstructor;

import static org.springframework.security.core.userdetails.User.*;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	@Autowired
	private UserRepository repo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private JWTService jwtService;
	@Autowired
	private AuthenticationManager aManager;

	public AuthenticationResponse register(RegisterRequest request) {

		//rohadt lombok nem működik normálisan
		com.ferenc.securityapp.user.User user = new com.ferenc.securityapp.user.User(null, request.getFirstName(), request.getLastName(), request.getEmail(), encoder.encode(request.getPassword()), Role.USER);

		repo.save(user);

		var jwtToken = jwtService.GerenrateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {


		aManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		com.ferenc.securityapp.user.User user = repo.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.GerenrateToken(user);

		return AuthenticationResponse.builder().token(jwtToken).build();


	}
}
