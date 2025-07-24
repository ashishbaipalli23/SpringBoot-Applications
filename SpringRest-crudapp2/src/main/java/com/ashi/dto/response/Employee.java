package com.ashi.dto.response;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Employee {

	private Integer eid;

	private String name;

	private String dept;

	private Double salary;

	private String phNo;
}
