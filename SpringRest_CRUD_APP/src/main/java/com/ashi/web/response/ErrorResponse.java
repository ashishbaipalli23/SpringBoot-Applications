package com.ashi.web.response;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
	
	private LocalDateTime timeStamp;
	
	private int status;
	
	private String errorMsg;
	
	private String path;
	
	private String method;

}
