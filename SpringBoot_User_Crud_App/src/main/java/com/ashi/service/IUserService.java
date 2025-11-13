package com.ashi.service;

import com.ashi.web.request.UserRegesterRequest;
import com.ashi.web.response.UserReponse;

public interface IUserService {
	
	String saveUser(UserRegesterRequest userRequest);
	
	UserReponse getUser(Integer uId) throws RuntimeException;
	
	String deleteUser(Integer uId);
	
	String updateUser(Integer uId,UserRegesterRequest userRequest);

}
