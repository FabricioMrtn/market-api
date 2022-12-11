package com.nv.marketapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nv.marketapi.dto.ProductDto;
import com.nv.marketapi.model.Product;
import com.nv.marketapi.repository.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductRepository prodRep;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid ProductDto dto) {
		prodRep.save(new Product(dto));
	}
	
}
