package com.example.auth.domain.user.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthorizationDto(@NotBlank String login,@NotBlank String password) {

}
