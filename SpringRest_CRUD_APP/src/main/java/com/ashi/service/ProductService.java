package com.ashi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashi.model.ProductEntity;
import com.ashi.repository.ProductRepository;
import com.ashi.web.request.ProductRegisterRequest;

//NOTE :[ DTO(web.request/web.respose) <-> ENTITY ] voice verse
@Service //business logic
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository repository;
	
	
	@Override
	public String addProduct(ProductRegisterRequest product) {
		
		ProductEntity productEntity = new ProductEntity();
		
		BeanUtils.copyProperties(product, productEntity);
		
		System.out.println("product entity :"+productEntity);
		
		//DB Logic
		repository.save(productEntity);
		
		
		
		return "product added successfully ...";
	}

}
