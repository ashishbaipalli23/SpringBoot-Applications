package com.ashi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product_tab")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;

	
	private String name;

	private Double price;

	private LocalDate expDate;

	
	private Integer stockQuantity;


	private String category;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt; 

	@Column(updatable = true)
	@UpdateTimestamp
	private LocalDateTime updatedAt; 

}
