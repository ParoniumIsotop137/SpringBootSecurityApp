package com.ferenc.securityapp.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	private static final String KEY = "294A404E635266556A586E327235753878214125442A472D4B6150645367566B";

	public String extractUserEmail(String jwtToken) {
		
		return extractOneClaim(jwtToken, Claims::getSubject);
	}
	
	public <T> T extractOneClaim(String token, Function<Claims, T> claimsResolver) {
		
		final Claims claims = ExtractAllClaims(token);
		return claimsResolver.apply(claims);
		
	}
	
	private Claims ExtractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
		
	}

	private Key getSigningKey() {
		
		byte [] bytes = Decoders.BASE64.decode(KEY);
		
		return Keys.hmacShaKeyFor(bytes);
	}
	
	public String GerenrateToken(UserDetails details) {
		return GenerateToken(new HashMap<>(), details);
	}
	
	public String GenerateToken(Map<String, Object> claims, UserDetails details) {
		
		return Jwts.builder().setClaims(claims).setSubject(details.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+1000*60*24)).signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
		
	}
	
	public boolean isTokenValid(String token, UserDetails details) {
		
		final String userEmail = extractUserEmail(token);
		
		return (userEmail.equals(details.getUsername())) && !isTokenExpired(token);
		
	}

	private boolean isTokenExpired(String token) {
		
		return ExtractExpiration(token).before(new Date());
	}

	private Date ExtractExpiration(String token) {
	
		return extractOneClaim(token, Claims::getExpiration);
	}

	
	
}
