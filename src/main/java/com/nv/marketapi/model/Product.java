package com.nv.marketapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.nv.marketapi.dto.ProductDto;

import jakarta.persistence.Column;
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

@Entity(name="Product")
@Table(name="products")
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
		this.description = dto.description().toUpperCase();
		this.costPrice = dto.cost();
		this.sellPrice = dto.sell();
		this.internalDescription = dto.internalDescription();
		this.registration = LocalDateTime.now();
		this.distributor = new Distributor(dto.distributor());
	}
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getInternalDescription() {
		return internalDescription;
	}

	public void setInternalDescription(String internalDescription) {
		this.internalDescription = internalDescription;
	}

	public LocalDateTime getRegistration() {
		return registration;
	}

	public void setRegistration(LocalDateTime registration) {
		this.registration = registration;
	}

	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

	public String stringLimiter(String text, int max) {
		return text.length() <= max ? text : text.substring(0, max);
	}

}
