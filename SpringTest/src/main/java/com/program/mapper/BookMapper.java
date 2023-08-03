package com.program.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.program.entity.Book;

@Mapper
public interface BookMapper {

	public List<Book> bookList();

	public void bookInsert(Book vo);

}
