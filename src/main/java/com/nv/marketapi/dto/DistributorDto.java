package com.nv.marketapi.dto;

import jakarta.validation.constraints.NotBlank;

public record DistributorDto(
		@NotBlank
		String cnpj,
		@NotBlank
		String name) {
}
