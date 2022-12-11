package com.nv.marketapi.dto;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ProductDto(
		@NotBlank
		@Pattern(regexp = "\\d{8,14}")
		Long code,
		@NotBlank
		String description,
		@NotBlank
		BigDecimal cost,
		@NotBlank
		BigDecimal sell,
		String internalDescription,
		@NotNull
		@Valid
		DistributorDto distributor) {
}
