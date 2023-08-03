package com.board.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Spring Framework는 annotation으로 기능에 대한 정의를 한다.
@Controller // --> POJO임을 나타내는 annotation / 요청이 들어오면 제일 먼저 들어오는 공간
public class HomeController {
	
	// log를 찍을 때 사용하는 도구 --> 굳이 사용안할거임!
 	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
 	// RequestMapping : 요청 url이 들어왔을 때, 실행해야하는 메소드 
 	// value = "/요청url", methon = GET or POST
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		// 이동 시 경로가 바뀌지 않는다! --> Spring은 forward 방식 이용한다!
		// ★★★★★★★★★최종적으로 이동해야하는 페이지의 명칭★★★★★★★★★
		// home : 논리적인 주소 값
		// WEB-INF/views/home.jsp(물리적인 주소)
		// Spring에서는 내부적으로 논리적인 주소 값을 물리적인 주소 값으로 변환
		// >> ViewResolver 
		// >> servlet-context.xml쪽에 보면 prefix, suffix로 기술되어있음.
		
	}
	
	

	
	
}
