package com.nv.marketapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.nv.marketapi.model.Product;

public record ProductList(
		Long id, 
		Long code, 
		String description,  
		BigDecimal cost,
		BigDecimal sell,
		LocalDateTime registration) {
	
	public ProductList(Product product) {
		this(
				product.getId(), 
				product.getCode(), 
				product.getDescription(), 
				product.getCostPrice(),
				product.getSellPrice(),
				product.getRegistration());
	}
}
