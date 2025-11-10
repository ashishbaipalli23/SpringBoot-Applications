package com.ashi.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users_tab")
@Setter
@Getter
@ToString
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer uId;
	
	@Column(nullable = false,length = 200,name = "user_name")
	String name;
	
	@Column(nullable = false,length = 200,unique = true)
	String email;
	
	@Column(nullable = false,length = 200,unique = true)
	String phone;
	
	@Column(nullable = false,length = 200)
	String address;
	
	@Column(nullable = false,length = 200)
	String role;
	
	@Column(nullable = false)
	Boolean activeSw = true; ///soft delete
	
	//auditing
	@CreationTimestamp
	@Column(updatable = false)
	LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column
	LocalDateTime updateAt;
	
	
	
}
