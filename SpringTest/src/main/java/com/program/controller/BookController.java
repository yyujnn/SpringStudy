package com.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.program.entity.Book;
import com.program.mapper.BookMapper;

@Controller
public class BookController {

	@Autowired
	BookMapper mapper;

	@RequestMapping("/bookList.do")
	public void bookList(Model model) {
		List<Book> list = mapper.bookList();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("/bookInsert.do")
	public String bookInsert(Book vo) {
		
		mapper.bookInsert(vo);
		return "redirect:/bookList";
	}

}
