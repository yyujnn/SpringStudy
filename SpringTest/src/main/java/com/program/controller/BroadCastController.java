package com.program.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.program.entity.Music;
import com.program.entity.SearchCriteria;
import com.program.mapper.BroadCastMapper;


@Controller
public class BroadCastController {

	// servlet-context 변경해주어야 함
	//	<!-- FC가 POJO를 찾을 수 있게 위치 등록 -->
	//<context:component-scan base-package="com.program.controller" />
	@Autowired 
	BroadCastMapper mapper;
	
	
	@RequestMapping("/")
	public String index(SearchCriteria cri, Model model) {
		System.out.println("검색기준>>"+cri);
		
		// 1. mapper 시청률 평균들을 조회
		Music result = mapper.getRatingData(cri);
		// 2. 평균을 jsp에 보내줄 수 있도록 Model에 담아주기
		model.addAttribute("result", result);
		
		
		return "index";
	}
	
	@RequestMapping("/register")
	public String register() {
		
		return "register";
	}
	
	
//	// ★★★ @ResponseBody ★★★
//	// ---> 비동기 통신 방식으로 요청이 들어온 경우 view이름이 아닌
//	//  	데이터 결과값을 반환하고 싶을 때 사용하는 annotation
//	@RequestMapping("/getMonthData")
//	public @ResponseBody ArrayList<Music> getMonthData() {
//		// 1. mapper 월별 시청률 평균 조회하기
//		// 행이 여러개면 -> List 형식으로 받아오기
//		// 행이 한개라면 -> 하나의 객체, 문자열, 숫자로 받아오기
//		ArrayList<Music> list  = mapper.getMonthData();
//		System.out.println(list);
//		// 2. 결과값 반환 --> 비동기 통신 !! 어떻게 반환?
//		// 비동기 통신으로 요청이 들어온 경우 결과값 반환하기 위해서는
//		// 반드시 웹 페이지 화면에 출력!!
//		// jsp/servlet ---> PrintWriter 꺼내와서 결과값은 Gson라이브러리 사용해서
//		//					JSON 구조로 변환 후 화면에 출력
//		// Spring --> 
//		
//		return list;
//	}
//	
//	@RequestMapping("/getAgeData")
//	public @ResponseBody Music getAgeData() {
//		// 1. mapper 연령대별 시청률 평균 조회하기
//		Music age = mapper.getAgeData();
//		System.out.println(age);
//		// 2. 결과값 반환
//		return age;
//		// ---> age를 화면에 출력할 수 있는 형태로 convert jackson-databind
//	}
	
	
}
