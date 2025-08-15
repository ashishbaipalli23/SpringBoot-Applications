package com.ashi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashi.exception.ResourceNotFoundException;
import com.ashi.mapper.ProductMapper;
import com.ashi.model.ProductEntity;
import com.ashi.repository.ProductRepository;
import com.ashi.web.request.ProductRegisterRequest;
import com.ashi.web.response.ProductResponse;


//NOTE :[ DTO(web.request/web.respose) <-> ENTITY ] voice verse
@Service //business logic
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ProductMapper mapper;
	
	@Override
	public ProductResponse addProduct(ProductRegisterRequest productRequest) {
//		
//		ProductEntity productEntity = new ProductEntity();
//		
//		BeanUtils.copyProperties(product, productEntity);
//		
//		System.out.println("product entity :"+productEntity);
//		
//		//DB Logic
//		ProductEntity productEntity1 = repository.save(productEntity);
//		
//		ProductResponse response = new ProductResponse();
//		BeanUtils.copyProperties(productEntity1, response);
		
		ProductEntity productEntity = mapper.toEntity(productRequest);
		
		//entity to DTO(Response)
		
		ProductResponse response = mapper.toDto(repository.save(productEntity));
		
		return response;
	}


	@Override
	public List<ProductResponse> getAllProduct() {
		
		//List<ProductEntity> productEntities = repository.findAll();
		/*
		 * //BeanUtils List<ProductResponse> responses = productEntities.stream()
		 * .map(productEntity -> { ProductResponse response = new ProductResponse();
		 * BeanUtils.copyProperties(productEntity, response); return response;
		 * }).toList();
		 */
		
		List<ProductResponse> reponses = mapper.toDtoList(repository.findAll());
		return reponses;
	
	}


	@Override
	public ProductResponse getProductById(Integer id) throws ResourceNotFoundException {
	
		ProductEntity productEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not Found With Id : " + id));
		
		
		ProductResponse reponse = mapper.toDto(productEntity);
		
		return reponse;
	}


	@Override
	public String deteleProduct(Integer id)throws ResourceNotFoundException {
		// id-> success delete 
		//id not found > rasie exception ResourceNotFoundException
		return null;
	}

	
	
	
	
	
	
	
	
	
}
