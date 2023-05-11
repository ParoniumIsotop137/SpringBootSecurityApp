package com.ferenc.securityapp.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/szekhaz/kezdolap")
@RequiredArgsConstructor
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService service;
	
	@PostMapping("/regisztracio")
	public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request){
		return ResponseEntity.ok(service.register(request));
		
	}
	
	@PostMapping("/azonositas")
	public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(service.authenticate(request));
		
	}

}
