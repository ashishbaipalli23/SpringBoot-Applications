package com.ashi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.*;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_tab")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	
	private String name; 
	
	private String dept;
	
	private Double salary;
	
	@Column(unique = true)
	private String phNo;
	
	
	
}
