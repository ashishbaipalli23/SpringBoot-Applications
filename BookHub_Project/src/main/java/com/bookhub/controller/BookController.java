package com.bookhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookhub.service.BookService;
import com.bookhub.web.request.BookRegisterRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/reg-book")
	public ResponseEntity<String> registerBook(@Valid @RequestBody(required = true) BookRegisterRequest bookRegisterRequest) {

		String response = bookService.addBook(bookRegisterRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

}
