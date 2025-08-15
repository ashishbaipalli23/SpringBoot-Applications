package com.ashi.web.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductResponse {
	
private Integer pid;

	
	private String name;

	private Double price;

	private LocalDate expDate;

	
	private Integer stockQuantity;


	private String category;

}
