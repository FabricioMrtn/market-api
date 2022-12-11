package com.nv.marketapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
//	private Fornecedor fornecedor;
//	private LocalDateTime cadastro;

	public Product(Long	code, String description, BigDecimal cost, BigDecimal sell) {
		this.code = code;
		this.description = stringLimiter(description, 50);
		this.costPrice = cost;
		this.sellPrice = sell;
		
	}
	
	public String stringLimiter(String text, int max) {
		return text.length() <= max ? text : text.substring(0, max);
	}

}
