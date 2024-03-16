package com.example.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.domain.product.dto.RequestProductDto;
import com.example.auth.domain.product.dto.ResponseProductDto;
import com.example.auth.domain.product.model.ProductModel;
import com.example.auth.repository.ProductRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ResponseProductDto> createProduct(@RequestBody @Valid RequestProductDto data){
		var product = new ProductModel(data);
		productRepository.save(product);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ResponseProductDto>> getAllProducts(){
		var products = productRepository.findAllByActiveTrue().stream().map(ResponseProductDto::new).toList();
		return ResponseEntity.ok(products);
	}
	
}
