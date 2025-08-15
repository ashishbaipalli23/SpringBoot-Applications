package com.ashi.web.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> {
	
	private int status;
	
	private String msg;
	
	private T data;
	
	private LocalDateTime timeStamp;

}
