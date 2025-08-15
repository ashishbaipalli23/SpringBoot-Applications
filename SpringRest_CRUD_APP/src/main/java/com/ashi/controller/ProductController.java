package com.ashi.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashi.exception.ResourceNotFoundException;
import com.ashi.service.ProductService;
import com.ashi.web.request.ProductRegisterRequest;
import com.ashi.web.response.APIResponse;
import com.ashi.web.response.ProductResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	// @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	@PostMapping(value = "/addproduct") // http://localhost:8989/product/addproduct
	public ResponseEntity<APIResponse<ProductResponse>> registerProduct(
			@Valid @RequestBody(required = true) ProductRegisterRequest productRequest) {

		
		ProductResponse productResponse = service.addProduct(productRequest);
		
		APIResponse<ProductResponse> res = APIResponse.<ProductResponse>builder()
				.status(HttpStatus.CREATED.value())
				.msg("Product Added Successfully")
				.data(productResponse)
				.timeStamp(LocalDateTime.now())
				.build();
		
		return ResponseEntity
		        .created(URI.create("/product/product-id/" + productResponse.getPid())) // sets 201 and Location header
		        .body(res);

//
//		return ResponseEntity
//				.status(HttpStatus.CREATED).header("resourse-Created-at", "/product-id/"+productResponse.getPid()).body(res);

	}

	
	@GetMapping("/getall")// ResponseEntity<?> ? means any datatype allowed
	public ResponseEntity<?> getAllProducts() {
		
		List<ProductResponse> allProduct = service.getAllProduct();
		
		if(allProduct.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products are Empty");
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(allProduct);
		
	}
	
	
	
	@GetMapping("/product-id/{id}")
	public ResponseEntity<?> showProductById(@PathVariable(required = true,name = "id") Integer productId) throws ResourceNotFoundException{
		ProductResponse response = service.getProductById(productId);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	
	
	
	
}
