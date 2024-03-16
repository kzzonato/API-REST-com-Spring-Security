package com.example.auth.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.auth.domain.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{
	
	UserDetails findByLogin(String login);
}
