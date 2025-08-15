package com.ashi.service;

import java.util.List;

import com.ashi.exception.ResourceNotFoundException;
import com.ashi.web.request.ProductRegisterRequest;
import com.ashi.web.response.ProductResponse;

public interface IProductService {
	
	ProductResponse addProduct(ProductRegisterRequest product);
	
	List<ProductResponse> getAllProduct();
	
	ProductResponse getProductById(Integer id) throws ResourceNotFoundException;
	
	String deteleProduct(Integer id) throws ResourceNotFoundException;

}
//USER (table) -> CRUD 
//id
//name
//email (username unique)
//password
//age,phone,address 
//role = default (string)