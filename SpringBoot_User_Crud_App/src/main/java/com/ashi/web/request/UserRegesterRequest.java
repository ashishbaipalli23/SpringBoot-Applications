package com.ashi.web.request;

import lombok.Data;

//DTO POJO BEAN
//JSON -> match

@Data
public class UserRegesterRequest {

	String name;

	String email;

	String phone;

	String address;

	String role;

	// Boolean activeSw = true;

}
