package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.Board;
import com.smhrd.repository.BoardRepository;

@Controller // -> POJO 파일임을 나타내는 annotation(Spring MVC와 동일함)
public class BoardController {
	
	
	@Autowired 
	BoardRepository repository;
	
	// boardList라는 url로 요청이 들어오면
	// boardList.html로 forward방식 이동
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		// Select * from board;
		// 1. DB에서 전체 게시글 조회하기
		List<Board> list = repository.findAll();
		// 2. model에 담아주기
		model.addAttribute("list", list);
		// 3. boardList.html로 forward방식으로 이동
		return "boardList";
		// SpringMVC에서는 
		// /WEB-INF/views/boardList.jsp
		// Springboot에서는 ..?
		// 내부 Template Engine(Thymeleaf Engine 사용)
		// resource/template/boardList.html

	}

	@RequestMapping("/insert")
	public String boardInsert() {
		
		return "boardInsert";
	}
	
	@PostMapping("/insert")
	public String boardInsert(Board vo) {
     	// System.out.println(vo);
		// 1. DB에 수집한 데이터를 insert
		repository.save(vo);
		
		// 2. boardList로 이동
		return "redirect:/boardList";
	}
	
	
	
	@RequestMapping("/delete")
	public String boardDelete(Board vo) {
		System.out.println("삭제 게시글 번호"+vo);
		repository.deleteById(vo.getNum());
		
		// delete(vo) ->  num만 들어있어서 가능
		return "redirect:/boardList";
	}
	
}
