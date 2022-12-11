package com.nv.marketapi.model;

import com.nv.marketapi.dto.DistributorDto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Distributor {
	private Long id;
	private Long cnpj;
	private String name;
	
	public Distributor() {}
	
	public Distributor(DistributorDto distributor) {
		this.cnpj = distributor.cnpj();
		this.name = distributor.name();
	}
}
