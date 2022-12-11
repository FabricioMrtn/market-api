package com.nv.marketapi.dto;

import jakarta.validation.constraints.NotBlank;

public record DistributorDto(
		@NotBlank
		Long cnpj,
		@NotBlank
		String name) {
}
