package com.bookhub.web.request;

import java.time.LocalDate;

import com.bookhub.model.AuthorEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Binding Class 
//JSON -> JAVA Object 
//FORM(html) -> JAVA Object

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRegisterRequest {

	private String title;

	private LocalDate publicationDate;

	private String isbn; 

	private Double price;

	private Long authorId;
	
}





