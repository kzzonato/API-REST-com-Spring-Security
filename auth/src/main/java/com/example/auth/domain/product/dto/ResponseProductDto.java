package com.example.auth.domain.product.dto;

import java.util.UUID;

import com.example.auth.domain.product.model.ProductModel;

public record ResponseProductDto(UUID id, String name, Integer price_in_cents) {

	public ResponseProductDto(ProductModel product) {
		this(product.getId(),product.getName(), product.getPrice_in_cents());
	}

}
