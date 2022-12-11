package com.nv.marketapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.nv.marketapi.dto.ProductDto;

import jakarta.persistence.Embedded;
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

@Entity(name = "Product")
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
	@Embedded
	private Distributor distributor;
	
	public Product() {}

	public Product(ProductDto dto) {
		this.code = dto.code();
		this.description = stringLimiter(dto.description(), 50);
		this.costPrice = dto.cost();
		this.sellPrice = dto.sell();
		this.internalDescription = stringLimiter(dto.internalDescription(), 100);
		this.registration = LocalDateTime.now();
		this.distributor = new Distributor(dto.distributor());
	}
	
	public String stringLimiter(String text, int max) {
		return text.length() <= max ? text : text.substring(0, max);
	}

}
