package com.ashi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashi.models.UserEntity;
import com.ashi.repository.UserRepository;
import com.ashi.web.request.UserRegesterRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public String saveUser(UserRegesterRequest userRequest) {
		
		log.info("userRequest : {} :"+userRequest);
		
		//userRequest -> DTO 
		//DTO -> Entity
		//setter/getter , modelMapper , mapSturct
		
		
		//setter and getter
		
		UserEntity entity = new UserEntity();
		entity.setName(userRequest.getName());
		entity.setEmail(userRequest.getEmail());
		entity.setAddress(userRequest.getAddress());
		entity.setRole(userRequest.getRole());
		entity.setPhone(userRequest.getPhone());
		
		log.info("enity : {} "+entity);
		
		
		UserEntity savedEntity = repository.save(entity);
		
		
		return "user register with id : "+savedEntity.getUId();
	}
	
	

}
