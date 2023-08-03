package com.smhrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpringBoot의 핵심!!
// 해당하는 파일이 없으면 작동을 하지 않아요!
@SpringBootApplication
public class SpringBootProjectApplication {
	
	// @SpringBootApplication
	// servlet-context.xml에 있떤 component-scan을 단순화 시킨 annotation
	// 1. 설정파일 단순화
	// --> servlet-context.xml, root-context.xml 등 설정파일이 있어야하는데
	// 	   application.properties읽어서 구동해야할 프로젝트를 준비해준다.
	// 2. Spring 기본 라이브러리, Bean(객체) Setting
	// 3. ★★★★Component-scan★★★★ 기능이 달려있다.
	// ---> 자동으로 해당하는 annotation이 달려있는 객체의 하위 패키지를 스캔한다.
	// 주의할 점 ! 반드시 새로 만드는 클래스 파일들은 
	// 		    무조건 SpringBootApplication보다 하위에 위치 시킬것

	
	// Spring boot는 main메소드가 시작점
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

}
