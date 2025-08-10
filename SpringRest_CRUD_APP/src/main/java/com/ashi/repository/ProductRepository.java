package com.ashi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashi.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

}
