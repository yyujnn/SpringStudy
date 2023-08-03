package com.board.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // --> 모든 필드의 값을 받아오는 생성자
@NoArgsConstructor // --> 기본 생성자
@Data // --> getter, setter
public class Board {

	private int num; // 게시글 번호
	private String title; // 게시글 제목
	private String writer; // 작성자
	private Date indate; // 날짜
	private String content; // 내용
	
	// MavenRepository >> lombok 
}
