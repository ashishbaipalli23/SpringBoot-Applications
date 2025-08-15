package com.ashi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ashi.model.ProductEntity;
import com.ashi.web.request.ProductRegisterRequest;
import com.ashi.web.response.ProductResponse;

@Mapper(componentModel = "spring") //it becomes Spring Bean and used for injection
public interface ProductMapper {
	
     ProductEntity toEntity(ProductRegisterRequest productRequest) ;
	
     ProductResponse toDto(ProductEntity entity);
	
	 List<ProductResponse> toDtoList(List<ProductEntity> productEntities) ;

}
