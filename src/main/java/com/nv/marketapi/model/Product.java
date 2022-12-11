package com.nv.marketapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.nv.marketapi.dto.ProductDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity(name = "Product")
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long code;
	private String description;
	private BigDecimal costPrice;
	private BigDecimal sellPrice;
	private String internalDescription;
	private LocalDateTime registration;
	//	private Fornecedor fornecedor;
	
	public Product() {}

	//for registration of a product
	public Product(ProductDto dto) {
		this.code = dto.code();
		this.description = stringLimiter(dto.description(), 50);
		this.costPrice = dto.cost();
		this.sellPrice = dto.sell();
		this.internalDescription = stringLimiter(dto.internalDescription(), 100);
		this.registration = LocalDateTime.now();
		
	}
	
	public String stringLimiter(String text, int max) {
		return text.length() <= max ? text : text.substring(0, max);
	}

}
