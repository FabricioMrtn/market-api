package com.nv.marketapi.dto;

import java.math.BigDecimal;

public record ProductDto(
		Long id,
		Long code,
		String description,
		BigDecimal cost,
		BigDecimal sell,
		String internalDescription
		) {

}
