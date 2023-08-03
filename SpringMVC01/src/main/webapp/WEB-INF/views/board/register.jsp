<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>게시판</title>
</head>
<body>

	<div class="jumbotron jumbotron-fluid">
	  <div class="container">
	    <h1>SpringMVC 게시판 연습</h1>
	    <p>지금부터 SpringFramework를 사용해서 게시판 만들기 연습을 해보겠습니다.</p>
	  </div>
	</div>
	<div class="container">
		<div class="card">
		  <div class="card-header">게시판</div>
		  <div class="card-body">
		  
		  	<form action="${cpath}/register" method="post">
			  <div class="form-group">
			    <label for="title">제목 : </label>
			    <input type="text" class="form-control" id="title" name="title">
			  </div>
			  <div class="form-group">
			    <label for="writer">작성자:</label>
			    <input type="text" class="form-control" id="writer" name="writer">
			  </div>
			  <div class="form-group">
			    <label for="content">내용:</label>
				<textarea class="form-control" rows="10" id="content" name="content"></textarea>
			  </div>
			  
			  <button type="submit" class="btn btn-primary">글쓰기</button>
			</form>
		  	 
	  	</div>
	  </div>
	  
	  
	  <div class="card-footer">산대특 빅데이터반 - 임경남 연구원</div>
	</div>



</body>
</html>