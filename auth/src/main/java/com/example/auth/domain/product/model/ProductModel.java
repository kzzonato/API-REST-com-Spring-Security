package com.example.auth.domain.product.model;

import java.util.UUID;

import com.example.auth.domain.product.dto.RequestProductDto;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="product")
@Table(name="product")      
@EqualsAndHashCode(of="id")
public class ProductModel {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;
	private Integer price_in_cents;
	private Boolean active;
	
	public ProductModel(RequestProductDto data) {
		this.name = data.name();
		this.price_in_cents = data.price_in_cents();
		this.active = true;
	}
	
}
