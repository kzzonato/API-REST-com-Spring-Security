package com.example.auth.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.domain.product.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, UUID>{

	List<ProductModel> findAllByActiveTrue();
}
