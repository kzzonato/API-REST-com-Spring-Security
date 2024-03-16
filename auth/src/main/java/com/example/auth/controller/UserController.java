package com.example.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.domain.user.dto.AuthorizationDto;
import com.example.auth.domain.user.dto.LoginResponse;
import com.example.auth.domain.user.dto.RegisterDto;
import com.example.auth.domain.user.model.UserModel;
import com.example.auth.infra.security.TokenService;
import com.example.auth.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenService tokenService;
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody @Valid AuthorizationDto data){
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = authenticationManager.authenticate(usernamePassword);	
		var token = tokenService.generateToken((UserModel) auth.getPrincipal());
	
		return ResponseEntity.ok(new LoginResponse(token));
	}
		
	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody @Valid RegisterDto data){
		if(userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
		
		var encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		var newUser = new UserModel(data.login(),encryptedPassword, data.role());
		userRepository.save(newUser);
		
		return ResponseEntity.ok().build();
	}
	
	
}
