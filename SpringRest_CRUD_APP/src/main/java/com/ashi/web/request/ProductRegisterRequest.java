package com.ashi.web.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

//binding class 
//we need to collect data from the FORM(HTML) /JSON or XML
@Data
public class ProductRegisterRequest {

	@NotBlank
	@NotNull
	private String name; //"" -> valid 

	@NotNull
	@Positive(message = "-ve values not allowed")
	private Double price;

	@NotNull
	@Future
	private LocalDate expDate;

	@NotNull
	@Positive(message = "-ve values not allowed")
	private Integer stockQuantity;

	@NotNull
	@NotBlank
	private String category;

}
