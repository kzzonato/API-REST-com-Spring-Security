package com.example.auth.domain.user.model;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GeneratorType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name="users")
@Table(name="users")
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements UserDetails{
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String login;
	private String password;
	private UserRole role;
	
	public UserModel(String login, String password, UserRole role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}
	@Override
	public String getUsername() {
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
	
}
