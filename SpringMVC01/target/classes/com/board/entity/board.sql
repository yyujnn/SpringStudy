/* board 테이블 생성
 * 번호, 제목, 작성자, 날짜, 내용
 * 클래스 내부의 필드 명칭과 테이블 컬럼명은 일치시킬 것
 */
CREATE TABLE board (
	num INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	writer VARCHAR(100) NOT NULL,
	indate datetime default now() ,
	content varchar(2000) not null,
	primary key(num)
);

insert into board(title,writer,content) 
values('DB 게시판 제목 1', '김운비', 'DB게시글입니다1');
insert into board(title,writer,content) 
values('DB 게시판 제목 2', '임경남', 'DB게시글입니다2');
insert into board(title,writer,content) 
values('DB 게시판 제목 3', '정유진', 'DB게시글입니다3');

select * from board;