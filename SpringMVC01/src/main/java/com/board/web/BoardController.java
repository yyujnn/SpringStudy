package com.board.web;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.entity.Board;
import com.board.mapper.BoardMapper;

@Controller
public class BoardController {
	
	// --> Spring container 내부에서 interface 구현한 객체와 자동으로 연결
	@Autowired 
	BoardMapper mapper;
	// 게시판 만들기 (전체 게시글 조회, 글 작성하기)
	
	// 1. 전체 게시글 조회
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		// 추후 DB 조회하는 작업
		ArrayList<Board> list = mapper.getBoardList();
		
		// boardList에 조회해 온 결과값을 돌려주기
		// --> forward방식으로 이동하고 있기 때문에 request scope에 담아서 보내주기
		// --> 필요한 scope들은 매개변수로 받아오면 spring 내부에서 알아서 채워준다.
		// request.setAttribute("list", list);
		model.addAttribute("list", list);
		// Model == HttpServletRequest
		
		return "board/boardList";
		// /WEB-INF/views/board/boardList.jsp
	}
	
	
	@GetMapping("/register") // ---> 전송방식이 get이었을 때 url mapping 잡아주는 방법
	public String register() {
		return "board/register";
	}
	
	
//	@RequestMapping(value = "/register", method=RequestMethod.POST)
	// PostMapping : web.xml -> filter 한글 인코딩
	@PostMapping("/register") // --> 전송방식이 post였을 때 url mapping 잡아주는 방법 
	public String register(Board vo) { // Spring에서 자동으로 수집
		// Spring은 form 태그로 전송받은 데이터를 자동으로 수집
		// 주의할 점 ! >> input태그의 name값과 객체의 필드명칭이 일치해야한다.
		// 			>> 객체의 기본 생성자와 setter 메소드가 반드시 있어야 작동한다.
		System.out.println(vo);
		
		// DB에 vo 안에 들어있는 데이터를 추가하기(게시글 추가하기)
		
		mapper.register(vo);
		
		// BoardRegister로 이동하면 추가X 이동
		
		// Spring에서 redirect방식으로 이동하기
		return "redirect:/boardList"; // register.jsp로 이동하기 --> boardList 검색
	}

	@RequestMapping("/boardContent/{num}")
	public String boardContent(@PathVariable("num") int n1 , Model model) {
		// parameter 수집 방법
		// 1. Board 객체로 수집 --> url key값과 Board의 필드 명칭이 일치!
		// 2. 데이터 자료형 변수명 --> url key값과 변수명이 일치! 
		//   path : <a href="${cpath}/boardContent?num=${b.num}">
		// 3. 일치시키고 싶지 않을 때 사용할 수 있는 annotation (매개변수 괄호 안에 작성) --> @PathVariable("key값")
		// ----------> 3번째 방식은 / 기준으로 Path(url)에 값을 포함시켜 보내주기 !!!
		

		System.out.println(n1);
		Board vo= mapper.boardContent(n1);
		System.out.println("결과값 >> "+vo);
		model.addAttribute("vo", vo);

		return "board/boardContent";
	}


	
	












}
