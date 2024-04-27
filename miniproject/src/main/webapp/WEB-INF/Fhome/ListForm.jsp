<%@page import="com.mini.project.Member"%>
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
	<div class="container-lg">
		<!-- 헤더부분-->
		
	<c:if test="${empty id}">
		<div class="header  rounded-3 text-bg-secondary p-3"  >
			<div class="row my-2">
				<div class="col d-flex justify-content-end mx-5 my-2">
					<a href="logForm" class="fw-bold link-light text-decoration-none">로그인</a>&nbsp; |  &nbsp;<a href="signForm" class="fw-bold link-light text-decoration-none">회원가입</a>
				</div>
			</div>
			<div class="row my-3">
				<div class="col">
					<h2 class="fs-1 text fw-bold text-center"> 커마 자랑 공간</h2>
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${not empty id}">
		<div class="header  rounded-3 text-bg-secondary p-3"  style="border :1px solid">
			<div class="row my-3">
				<div class="col d-flex justify-content-end mx-5 my-2">
					 <a href=logoutPro id="logOut" class="fw-bold link-light text-decoration-none">  회원정보 수정</a> &nbsp;| &nbsp;<a href=logoutPro id="logOut" class="fw-bold link-light text-decoration-none">로그아웃</a>
				</div>
			</div>
			<div class="row my-3">
			<div class="col">
				<h2 class="fs-1 text fw-bold text-center"> 커마 자랑 공간</h2>
			</div>
		</div>
		<div class="row">
			<div class="col  d-flex justify-content-end mx-5 my-2">
				${nick}님 어서오세요 ~~
			</div>
		</div>
		</div>
		</c:if>





		<!--센터부분-->
<form name="imgList" id="imgList" ${not empty list.conFile ? "" : "enctype='multipart/form-data'"}>
		<div class="row  justify-content-center my-5">
			<div class="col-auto">
				<select name="type" class="form-select" >
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
		<div class="row d-flex justify-content-between my-2">
			<div class="col-3 mx-4">
				<a href="writeForm?pageNum=${currentPage }" class="btn btn-outline-success" >글쓰기</a>
			</div>
			<div class="col-1 mx-4" >
				<select class="form-select form-select-sm" aria-label="Small select example" name="page" id="pageSelect" onchange="window.open(value,'_self');">
					<c:forEach var="i" begin="${startPage }" end="${endPage}">
						<option name="pageOption" id = "pageOption" value="imgList?pageNum=${i}">${i }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class = "row-lg  my-3 mx-5 ">
			<div class="col mx-2 d-flex flex-wrap  ">
			<c:forEach var="list" items="${cList }">
					<!--  커마 글 -->
					<div class="rounded-3  border border-dark  d-flex flex-column align-items-center text-start m-3" style="width: 200px; height: 270px; background-color: rgba(255,0,0,0.1); margin-right: 20px;">
						<div class="row my-3">
							<div class="col ">
								<!-- 이미지가 들어가는 자리 -->
								<c:if test="${empty list.conFile }">
									<img alt="" src="https://via.placeholder.com/160" class="rounded-3" >
								</c:if>
								<c:if test="${not empty list.conFile }">
									<img src="upload/${list.conFile}" class="rounded-3" style="width:160px; height:160px;" >
								</c:if>
							</div>
						</div>
						<div class="row">
							<div class=" mb-2 fw-bold d-flex  justify-content-start" style="width: 160px; height: 15px; font-size:10px;  ">
								<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}">${ list.conTitle}</a>
							</div>
						</div>
						<div class="row">
							<div class=" mb-2 fw-bold d-flex  justify-content-start" style="width: 160px; height: 15px; font-size:10px;  ">
								${list.userId}
							</div>
						</div>
						<div class="row mb-3 my-1 " style="width: 160px; height: 15px; font-size:10px;">
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
		</form>
			<div class="row">
			<div class="col">
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<c:if test="${startPage>pageGroup}">
							<li class="page-item"><a class="page-link" href="imgList?pageNum=${startPage - pageGroup}">Prev</a></li>
						</c:if>
						
						<c:forEach var="i" begin="${startPage }" end="${endPage}">
							<!-- 현재페이지인경우 -->
							<c:if test= "${i == currentPage }">
							<li class="page-item active"><a class="page-link" href="imgList?pageNum=${i}">${i}</a></li>
							</c:if>
							
							<c:if test="${i!=currentPage}">
							<li class="page-item"><a class="page-link" href="imgList?pageNum=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${endPage<pageCount}">
							<li class="page-item"><a class="page-link" href="imgList?pageNum=${startPage + pageGroup}">next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
		<!--푸터부분-->
	</div><!-- 컨트롤러 끝 -->
	<script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>