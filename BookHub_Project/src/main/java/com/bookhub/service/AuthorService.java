package com.bookhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookhub.mapper.AuthorMapper;
import com.bookhub.model.AuthorEntity;
import com.bookhub.repository.AuthorRepository;
import com.bookhub.web.request.AuthorRegisterRequest;
@Service
public class AuthorService implements IAuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private AuthorMapper mapper;
	
	@Override
	public String addAuthor(AuthorRegisterRequest authorRegisterRequest) {
		
		AuthorEntity entity = authorRepository.save(mapper.toEntity(authorRegisterRequest));
		
		return "auther saved with id "+entity.getId();
	}

}
