package com.program.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	private int num;
	private String title;
	private String author;
	private String company;
	private String isbn;
	private int count;
	

}
