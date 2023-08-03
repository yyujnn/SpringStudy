package com.program.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchCriteria {
	// 검색의 기준을 잡아주는 클래스(자료형, 도구)
	
	private String type; // 어떤 값을 기준으로 검색할 건지
	private String content; // 입력한 값 

}
