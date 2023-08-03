package com.program.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Music {
	// 테이블 하나를 표현할 수 있는 사용자 정의 자료형
	// ---> 클래스이름 : 테이블명 일치
	
	private int num;
	private String brdcst_de;
	private String program_nm;
	private float nyo_rt;
	private float n10s_rt;
	private float n20s_rt;
	private float n30s_rt;
	private float n40s_rt;
	private float n50s_rt;
	private float n60s_above_rt;
	private float male_rt;
	private float female_rt;
	private float wtchng_rt;
	private String fixing_cast_nm ;
	private String cast_nm ;
	
}
