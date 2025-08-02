package com.ashi.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/res")
public class ResponseEntityController {
	
//	@GetMapping("/index")
//	public String index() {
//		return "index"; // it is not a view name
//	}
	
	@GetMapping("/index")
	public ResponseEntity<String> index() {
		
		//create object for response entity
		
	//	return new ResponseEntity<String>("index",HttpStatusCode.valueOf(201));//HttpStatus -> ENUM
		
		//builder pattern
		/*
		 * return ResponseEntity .status(HttpStatus.CREATED) //.status(201)
		 * .body("index body page");
		 */
		
		//ok status
		return ResponseEntity.ok("index body page");
	
	}
	
	//headers used in downloades
	
	@GetMapping("/download")
	public ResponseEntity<String> downloadFile() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=data.txt");
		
	    return ResponseEntity.ok()
	        //.header("Content-Disposition", "attachment; filename=data.txt")
	    		.headers(headers)
	        .body("File content goes here");
	}
	

	
	@GetMapping("/read-header")
	public ResponseEntity<String> readHeader(@RequestHeader("User-Agent") String userAgent) {
	    return ResponseEntity.ok("Your browser is: " + userAgent);
	}
	
	
	//cashing -> storing data (@Cacheble(small)  and more advanced in redis(big application))
	//we can set the headers to store the response(text/image/html ect) in cache
	
	
	// //.header("Cache-Control", "public, max-age=60")
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
