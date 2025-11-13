package com.ashi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashi.service.UserService;
import com.ashi.web.request.UserRegesterRequest;
import com.ashi.web.response.UserReponse;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/register") // http://localhost:8080/user/register -> end point method
	public ResponseEntity<?> registerUser(@RequestBody UserRegesterRequest request) {
		String response = service.saveUser(request);
		return ResponseEntity.status(200).body(response);
	}

	@GetMapping("/get-user/{uid}") // path variable / parameters
	public ResponseEntity<?> getUser(@PathVariable(name = "uid") Integer userId) {
		UserReponse reponse = service.getUser(userId);

		return ResponseEntity.ok(reponse);

	}

	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<?> deleteUser(@PathVariable(name = "uid") Integer userId) {

		String response = service.deleteUser(userId);

		return ResponseEntity.ok(response);

	}

	@PutMapping("/update/{uid}")
	public ResponseEntity<?> update(@PathVariable(name = "uid") Integer userId,
			@RequestBody UserRegesterRequest updateRequest) {

		String response = service.updateUser(userId, updateRequest);

		return ResponseEntity.ok(response);

	}

}
