package com.nv.marketapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nv.marketapi.dto.ProductDto;
import com.nv.marketapi.dto.ProductList;
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
	public void register(@RequestBody @Valid ProductDto dto) {
		prodRep.save(new Product(dto));
	}
	
	@GetMapping
	public Page<ProductList> list(Pageable page){
		return prodRep.findAll(page).map(ProductList::new);
	}
	
}
