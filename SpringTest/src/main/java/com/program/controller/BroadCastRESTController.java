package com.program.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.program.entity.CastCount;
import com.program.entity.Music;
import com.program.mapper.BroadCastMapper;

@RestController // --> Controller + ResponseBody annotation
public class BroadCastRESTController {
	// 비동기통신 방식으로 요청이 들어온 경우 응답을 돌려주는 Controller

	// REST
	// Representational State Transfer

	@Autowired
	BroadCastMapper mapper;

	@RequestMapping("/getMonthData")
	public ArrayList<Music> getMonthData(String name) {
	
		ArrayList<Music> list = mapper.getMonthData(name);
		
		System.out.println(list);
		return list;
	}

	@RequestMapping("/getAgeData")
	public Music getAgeData(String name) {
		Music age = mapper.getAgeData(name);
		System.out.println(age);
		return age;
	}

	@RequestMapping("/getCastName")
	public ArrayList<CastCount> getCastName(String name) {
		System.out.println("프로그램 이름 "+name);
		
		// 1. DB에서 데이터 조회하기
		ArrayList<Music> list = mapper.getCastName(name);
		System.out.println("캐스팅 이름 출력 >> " + list);

		// ===1step==
		// fixing_cast_nm, cast_nm에 들어있는 이름들을
		// , 기준으로 쪼개서 한개의 자료형에 전부 담기
		// String[] arr = list.get(0).getCast_nm().split(",");

		// 캐스팅 된 연예인들의 이름을 전부 모아주는 자료형 1개 생성
		ArrayList<String> nameList = new ArrayList<String>();
		for (Music m : list) {
			String[] arr1 = m.getFixing_cast_nm().split(",");
			for (String s : arr1) {
				nameList.add(s);
			}
			String[] arr2 = m.getCast_nm().split(",");
			for (String s : arr2) {
				nameList.add(s);
			}
		}
		System.out.println("이름 모음 >>" + nameList);

		// ===2step===
		// nameList에 있는 String데이터의 중복값을 제거
		// Collection --> ArrayList, HashMap, HashSet
		// HashSet --> 중복된 값을 가질 수 없는!! 순서가 없는 집합 자료구조
		// ---> 데이터를 한개씩 꺼내려면 Iterator 따로 사용해야함!
		// LinkedHashSet --> 중복된 값을 가질 수 없는 순서가 있는 집합 자료구조
		LinkedHashSet<String> nameHashset = new LinkedHashSet<String>(nameList);
		System.out.println("중복 제거 값>>" + nameHashset);

		// ===3step===
		// 이름, 개수를(CastCount) 저장할 수 있도록 하는 자료구조 생성
		ArrayList<CastCount> result = new ArrayList<CastCount>();

		// ===4step===
		// 이름별로 출연 횟수 카운드
		// 중복제거한 결과값 >> nameHashSet
		// 모든 이름들이 들어있는 자료형 >> nameList
		for (String s : nameHashset) {
			if (!s.equals("")) {
				// Collections.frequency(자료구조, 개수를 세고 싶은 객체)
				// ---> 자료구조 안에 객체가 몇 번 들어있는 지 정수 형태로 되돌려준다.
				int i = Collections.frequency(nameList, s); // s가 몇번(이름만)
				// 이름-횟수 result 넣어주기
				result.add(new CastCount(s, i));
			}
		}

		// ===5step===
		// 내림차순 정렬하기
		// 객체 안에 있는 하나의 필드값을 기준으로 정렬하는 게 가능할까??
		// Comparator --> 객체를 비교하는 도구
		// 익명 객체 --> 한번만 사용할 인터페이스 함수를 호출할 때 쓰는 방식
//		Collections.sort(result, new Comparator<CastCount>() {
//			@Override
//			public int compare(CastCount o1, CastCount o2) {
//				return o2.getCount() - o1.getCount();
//				// return 값이 음수라면 왼쪽으로 정렬(오름차순 정렬)
//				// 양수라면 오른쪽으로 정렬(내림차순)
//			}
//
//		});
		
		// 익명함수를 호출 시 사용할 수 있는 람다식
		// (함수의 매개변수들) -> 리턴하고 싶은 결과값
		Collections.sort(result,(o1,o2)->o2.getCount()-o1.getCount());

		System.out.println("정렬된 결과값>>" + result);
		return result;
	}
}
