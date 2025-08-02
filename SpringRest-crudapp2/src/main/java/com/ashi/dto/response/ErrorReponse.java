package com.ashi.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorReponse {

	private String errorMessage;

	private LocalDateTime timestamp;

	private String path;
	
	private String method;

	
	
	

}
