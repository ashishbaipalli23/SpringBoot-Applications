package com.ashi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashi.service.UserService;
import com.ashi.web.request.UserRegesterRequest;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/register") // http://localhost:8080/user/register -> end point method
	public ResponseEntity<?> registerUser(@RequestBody UserRegesterRequest request){
		String response = service.saveUser(request);
		return ResponseEntity.status(200).body(response);
	}
	


}
