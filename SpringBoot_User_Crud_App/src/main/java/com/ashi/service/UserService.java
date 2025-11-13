package com.ashi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashi.models.UserEntity;
import com.ashi.repository.UserRepository;
import com.ashi.web.request.UserRegesterRequest;
import com.ashi.web.response.UserReponse;

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

	@Override
	public UserReponse getUser(Integer uId) throws RuntimeException {
		
		UserEntity entity = repository.findById(uId).orElseThrow(() -> new RuntimeException("User not found with id : "+uId));
		
		
		UserReponse response = new UserReponse();
		response.setName(entity.getName());
		response.setEmail(entity.getEmail());
		response.setPhone(entity.getPhone());
		response.setAddress(entity.getAddress());
		response.setRole(entity.getRole());
		return response;
	}

	@Override
	public String deleteUser(Integer uId) {
		//id -> presents -> delete
		
		Optional<UserEntity> entity = repository.findById(uId);
		
		if(entity.isPresent()) {
			repository.delete(entity.get());
			return "user deleted";
		}
		
		return "user not found";
	}

	@Override
	public String updateUser(Integer uId, UserRegesterRequest userRequest) {
		log.info("userRequest : {} :"+userRequest);
		UserEntity entity = repository.findById(uId).orElseThrow(() -> new RuntimeException("User not found with id : "+uId));
		entity.setName(userRequest.getName());
		entity.setEmail(userRequest.getEmail());
		entity.setPhone(userRequest.getPhone());
		entity.setAddress(userRequest.getAddress());
		repository.save(entity); //update
		return "user updated";
	}
	
	
	
	

}
