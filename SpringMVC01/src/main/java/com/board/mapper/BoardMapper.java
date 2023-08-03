package com.board.mapper;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Select;

import com.board.entity.Board;

public interface BoardMapper {
	// 반드시 xml 파일과 이름이 동일해야한다!
	
	// Connection 객체 생성, 사용, 결과값 만들어주기 --> Spring 
	// DB 연결 설정만 우리는 해주면 된다!
	public ArrayList<Board> getBoardList();
		
	public void register(Board vo);
	
	@Select("SELECT * FROM BOARD WHERE NUM =#{n1}")
	public Board boardContent(int n1); 
	// Mappper interface --> annotation 사용 sql 구문 실행
	// 메소드 위쪽에 작성
	
	// Spring 내부에서 알아서 작동시킨다.
	//-----------
	// SqlSession session = SqlSessionFactory.openSession(true);
	// List<Board> list= session.selectList("getBoardList");
	// session.close();
	//-----------
	
}
