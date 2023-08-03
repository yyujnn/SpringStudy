package com.smhrd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // --> persistence.Entity 사용할 것 !!!
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {
	
	@Id // -> primary key를 의미하는 annotation
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	
	private String title;
	
	// indate --> 현재 날짜를 자동으로 넣어주기
	//			 (columnDefinition : 컬럼에 대한 디테일한 설정을 잡아줄 수 있는 option)
	// 		  --> 수정 불가능하게 만들기
	@Column(insertable=false ,columnDefinition = "datetime default now()", updatable = false)
	private Date indate;
	
	private String writer;
	
	private String content; 
	

}
