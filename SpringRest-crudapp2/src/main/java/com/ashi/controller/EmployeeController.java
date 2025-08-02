package com.ashi.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashi.dto.response.Employee;
import com.ashi.model.EmployeeEntity;
import com.ashi.repository.EmployeeRespository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRespository repo;

	@PostMapping(value = "/add-emp", produces = "text/plain", consumes = { "application/json", "application/xml" })
	public String addEmployee(@RequestBody Employee employee) {
		// convert this Employee object(dto) to EmployeeEntity object
		// using BeanUtils
		
		EmployeeEntity empEntity = new EmployeeEntity();

		BeanUtils.copyProperties(employee, empEntity);

		System.out.println("Employee Entity : "+empEntity);
		
		EmployeeEntity save = repo.save(empEntity);

		return "employee saved with id " + save.getEid();

	}
	
	
	@GetMapping(value = "/getemp/{eid}",produces = { "application/json", "application/xml" })
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer eid) {
		
		Employee employee = new Employee();
		
		EmployeeEntity employeeEntity = repo.findById(eid).orElseThrow(() -> new RuntimeException("Employee not found with ID :"+eid));//Execption handeler
		//we can use @RestControllerAdvice
		//Entity to DTO
		
		BeanUtils.copyProperties(employeeEntity,employee);
		
		System.out.println("employee dto : "+employee);
		
		return ResponseEntity.status(200).body(employee); //ok(body)
		
	}
	
	
	//delete employee
	
	@DeleteMapping("/delete-emp/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer eid) {
		
		
//		boolean status = repo.existsById(eid);
//		if(status) {
//
//			repo.deleteById(eid);
//			
//			return ResponseEntity.ok("employee deleted with id : "+eid);
//		}
//		else {
//			return ResponseEntity.status(404).body("employee not found with id : "+eid);
//		}
		
		
		EmployeeEntity employeeEntity = repo.findById(eid).orElseThrow(() -> new RuntimeException("Employee not found with ID :"+eid));
		repo.deleteById(eid);
		
		return ResponseEntity.ok("employee deleted with id : "+employeeEntity.getEid());
		
		
		
	}
	
	
	
	

}
