package com.bookhub.mapper;

import org.mapstruct.Mapper;

import com.bookhub.model.AuthorEntity;
import com.bookhub.web.request.AuthorRegisterRequest;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
	
	//DTO to Entity
	AuthorEntity toEntity(AuthorRegisterRequest dto);

}
