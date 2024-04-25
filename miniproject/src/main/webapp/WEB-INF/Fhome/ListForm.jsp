<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>커스텀마이징</title>
<link href="bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- 헤더부분-->
		<div class= "row">
			<div class="col">
				<h1>header</h1>
			</div>
		</div>
		<c:if test="${empty member.userId}">
		<div class="row">
			<div class="col">
				<a href="logForm">로그인</a> | <a href="signForm">회원가입</a>
			</div>
		</div>
		</c:if>
		<c:if test="${not empty member.userId}">
		<div class="row">
			<div class="col">
				${member.userId }님 어서오세요~~
			</div>
		</div>
		</c:if>





		<!--센터부분-->
		<div class="row my-5">
			<div class="col">
				<h2 class="fs-1 text fw-bold text-center"> 커마 자랑 공간</h2>
			</div>
		</div>
		<div class="row  justify-content-center my-5">
			<div class="col-auto">
				<select name="type" class="form-select">
					<option value="title">제목</option>
					<option value="writer">작성자</option>
				</select>
			</div>
			<div class="col-4">
				<input type="text" name="keyword" class="form-control" id="keyword" />
			</div>
			<div class="col-auto">
				<input type="submit" value="검 색" class="btn btn-primary" />
			</div>
		</div>
		<div class="row d-flex justify-content-between my-5">
			<div class="col-3">
				<a href="writeForm" class="btn btn-outline-success">글쓰기</a>
			</div>
			<div class="col-1" >
				<select class="form-select form-select-sm" aria-label="Small select example" name="page">
					<option value=${i }>1</option>
				</select>
			</div>
		</div>
		<div class = "row  my-5  justify-content-center">
			<div class="col d-flex flex-wrap ">
			<c:forEach var="list" items="${cList }">
					<!--  커마 글 -->
					<div class="rounded-3 border border-dark  d-flex flex-column align-items-center text-start m-3" style="width: 200px; height: 250px; background-color: rgba(255,0,0,0.1);">
						<div class="row my-3">
							<div class="col ">
								<img alt="" src="https://via.placeholder.com/160" class="rounded-3" >
							</div>
						</div>
						<div class="row">
							<div class=" mb-2 fw-bold" style="width: 160px; height: 15px; font-size:10px;  ">
								<span><a href="ListDetail?no=${list.contentNo}">${ list.conTitle}</a></span>
							</div>
						</div>
						<div class="row mb-3 " style="width: 160px; height: 15px; font-size:10px;">
							<div class="col-2 d-flex text-start">
								<img src="./icon/eye.png" style="width:12px; margin-right: 5px;" >
								${ list.conCount}
							</div>
							<div class="col-6"></div>
							<div class="col-2 d-flex">
								<img src="./icon/good.png"  style="width:12px; margin-right: 5px;">
								${ list.conGood}
							</div>
						</div>
					</div><!--커마끝  -->
			</c:forEach>
			</div>
		</div>
		<!--푸터부분-->
	</div><!-- 컨트롤러 끝 -->
	<script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>