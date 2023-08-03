package com.smhrd.repository;

import java.util.List;

import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Board;

// SpringMVC @Mapper --> 생략 가능해서 안썼음 !
@Repository // --> component scan 할 수 있도록 annotation 추가
public interface BoardRepository extends JpaRepository<Board, Long> {
	// SpringMVC로 치면 BoardMapper 역할 !
	// !주의할 점!
	// -> JpaRepository는 interface지만 extends 키워드를 써서 상속받는다.
	// <테이블 역할을 하는 클래스, primary key의 자료형>
	
	
	// JpaRepository를 상속받음으로써
	// 기본 CRUD 메소드를 사용할 수 있다.
	
	// JPA는 메소드명을 기준으로 SQL구문을 생성하는 API
	
	// 1) findAll()
	// ---> SELECT * FROM BOARD
	// 2) findById(id)
	// ---> SELECT * FROM BOARD WHERE ID = #{id}
	// 3) save(Board)
	// ---> id(num) 값이 없으면 insert 진행
	// ---> id(num) 값이 있으면 update 진행
	// update board set title = ?, content =? , writer =?
	// where num = #{num}
	
	// 내가 나만의 SQL구문을 작성하고 싶다면?
	// 작성자를 기준으로 게시글을 조회하고 싶어요!
	// SELECT * FROM BOARD WHERE WRITER = ?
	// find + Board + By + Writer --> List<Board>
	public List<Board> findBoardByWriter(Board writer);
	
	
	
	// 작성자와 제목이 일치하는 게시글을 조회하고 싶어요!
	// SELECT * FROM BOARD WHERE WRITER = ? AND TITLE =?
	// find + Board + By + Writer + And + Title
	public List<Board> findBoardByWriterAndTitle(String writer, String title);
	// --> find만 구현되는 문법



	
	// Delete, update, insert 구문을 기본으로 제공되는 게 아닌
	// 새롭게 정의하고 싶다면???
	// @SQLInsert(sql = "insert into board ~~~~~")
	// public void saveByWriter(Board b);
	
	// JPA에서 쿼리문 추가할때 사용하는 annotation
	// @Query
	
	// 규칙
	// find + 테이블명(생략가능) + By + 컬럼명 + And(Or)
	// ---> 반드시 Camel식 기법 사용하기


	
}
