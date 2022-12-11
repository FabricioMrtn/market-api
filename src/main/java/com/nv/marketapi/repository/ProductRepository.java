package com.nv.marketapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nv.marketapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
