package com.ashi.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ashi.web.response.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ProductExceptionHaddling {
	
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> productRegisterRequestHaddler(MethodArgumentNotValidException ex,HttpServletRequest req){
		
		 String errorMessage = ex.getBindingResult().getFieldErrors()
			        .stream()
			        .map(error -> error.getField() + ": " + error.getDefaultMessage())
			        .findFirst()
			        .orElse("Invalid input");
		 
		 ErrorResponse errorBody = ErrorResponse.builder()
				                    .timeStamp(LocalDateTime.now())
				                    .path(req.getRequestURI())
				                    .method(req.getMethod())
				                    .status(HttpStatus.BAD_REQUEST.value())
				                    .errorMsg(errorMessage)
				 					.build();
		 

	     return ResponseEntity.badRequest().body(errorBody);
		
	}
	
	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> productRegisterRequestHaddler(ResourceNotFoundException ex,HttpServletRequest req){
		 
		 ErrorResponse errorBody = ErrorResponse.builder()
				                    .timeStamp(LocalDateTime.now())
				                    .path(req.getRequestURI())
				                    .method(req.getMethod())
				                    .status(HttpStatus.BAD_REQUEST.value())
				                    .errorMsg(ex.getMessage())
				 					.build();
		 

	     return ResponseEntity.badRequest().body(errorBody);
	}
	
	
	
	
	
	@ExceptionHandler(Exception.class)
	public String globalExecption(Exception ex) {
		
		return "something is fishy :"+ex.getMessage();
		
	}


	
}
