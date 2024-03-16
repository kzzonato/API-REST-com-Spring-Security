package com.example.auth.domain.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProductDto(@NotBlank String name,@NotNull Integer price_in_cents) {

}
