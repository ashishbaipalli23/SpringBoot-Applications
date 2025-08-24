package com.bookhub.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Setter
@Getter
//child
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	private String title;
	
	@Column(nullable = false)
	private LocalDate publicationDate;
	
     @Column(unique = true)
	private String isbn; // International Standard Book Number

     private Double price;
	// Many books -> one author
	@ManyToOne(cascade = CascadeType.ALL) //Saving Parent from the child
	@JoinColumn(name = "author_id", nullable = false)
	private AuthorEntity author; // foreign key

}
