package com.bookhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookhub.service.AuthorService;
import com.bookhub.web.request.AuthorRegisterRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService service;
	
	@PostMapping("/add-author")
	public String addAuthor(@Valid @RequestBody(required = true) AuthorRegisterRequest authorRegisterRequest) {
		
		String reponse = service.addAuthor(authorRegisterRequest);
		
		return reponse;
	}
	
	
	
}
