package com.ashi.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ashi.dto.response.ErrorReponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<String> handelingException(RuntimeException ex){
//		
//		String msg = ex.getMessage();
//		return ResponseEntity.badRequest().body(msg);
//		
//	}

	// now i am used ErrorReponse

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorReponse> handelingException(RuntimeException ex,HttpServletRequest
			req){
		
		   ErrorReponse errorBody = ErrorReponse.builder()
				                     .errorMessage(ex.getMessage())
				                      .timestamp(LocalDateTime.now())  
				                      .path(req.getRequestURI())
				                      .method(req.getMethod())
				                     .build();
		   
		   return ResponseEntity.status(500).body(errorBody);
	}

}
