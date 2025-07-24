package com.buyAndSell.server.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.buyAndSell.server.entities.User;
import com.buyAndSell.server.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * To-do:
	 * You can improve this later with:
	 * RS256 signature verification using Supabase public key
	 * 
	 * Filter-based middle ware to auto-verify JWT
	 * 
	 * Role-based access control using claims
	 **/
	@GetMapping("/user")
	public Optional<User> getUser(@RequestHeader("Authorization") String authHeader) {
		try {
			String token = authHeader.replace("Bearer ", "");
			DecodedJWT jwt = JWT.decode(token);
			String email = jwt.getClaim("email").asString();
			return userRepository.findByEmail(email);
		} catch (Exception e) {
			return null;
		}
	}
}
