package com.ashi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashi.model.EmployeeEntity;

public interface EmployeeRespository extends JpaRepository<EmployeeEntity, Integer> {

}


