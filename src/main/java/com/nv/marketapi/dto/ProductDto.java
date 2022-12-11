package com.nv.marketapi.dto;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ProductDto(
		@NotNull
		Long code,
		@NotBlank
		String description,
		@NotNull
		BigDecimal cost,
		@NotNull
		BigDecimal sell,
		String internalDescription,
		@NotNull
		@Valid
		DistributorDto distributor) {
}
