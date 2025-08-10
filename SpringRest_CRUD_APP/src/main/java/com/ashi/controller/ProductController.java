package com.ashi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashi.service.ProductService;
import com.ashi.web.request.ProductRegisterRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	//@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	@PostMapping(value = "/addproduct") 	  	//http://localhost:8989/product/addproduct
    public ResponseEntity<String> registerProduct(@Valid @RequestBody(required = true) ProductRegisterRequest productRequest){
		
		
		
		String res = service.addProduct(productRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
		
		
	}
	
	

}
