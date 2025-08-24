package com.bookhub.mapper;

import org.mapstruct.Mapper;

import com.bookhub.model.BookEntity;
import com.bookhub.web.request.BookRegisterRequest;

@Mapper(componentModel = "spring") //Spring Bean
public interface BookMapper {

	//DTO to Entity 
	BookEntity toEntity(BookRegisterRequest dto);
	
}
