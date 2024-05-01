<%@page import="com.mini.project.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
			
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>커스텀마이징</title>
<link href="bootstrap/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="container-lg" style ="width:1500px; height: 1600px;">
	<div class="row d-flex justify-content-center">
		<img src="./icon/배너2투명도.png" class="z-n1 position-absolute p-5 rounded-3"style = " 	width: 1390px; background-repeat: no-repeat; background-position: center center;	height: 1500px;">
	</div>
		<!-- header  -->
		<%@ include file="../page/header.jsp"%>

		<!--센터부분-->
<form name="imgList" id="imgList" ${not empty list.conFile ? "" : "enctype='multipart/form-data'"} >
		<div class="row  justify-content-center my-5">
			<div class="col-auto">
				<select name="type" class="form-select" >
					<option value="con_title">제목</option>
					<option value="userId">작성자</option>
				</select>
			</div>
			<div class="col-4">
				<input type="text" name="keyword" class="form-control" id="keyword" />
			</div>
			<div class="col-auto">
				<input type="submit" value="검 색" class="btn btn-primary" />
			</div>
		</div>
		</form>
		<div class="row d-flex justify-content-between my-2">
			<div class="col-3 mx-5">
				<a href="writeForm?pageNum=${currentPage }&type=${type}&keyword=${keyword}&shareType=${shareType}" class="btn btn-dark " >글쓰기</a>
			</div>
			<div class="col d-flex justify-content-end my-1 ">
					상시 공유 : &nbsp;
				  <input class="form-check-input" name="shareType" type="checkbox" value="${shareType }" onclick="updateShareType(this);">
			</div>
			<div class="col-1 mx-5" >
				<select class="form-select form-select-sm" aria-label="Small select example" name="page" id="pageSelect" onchange="window.open(value,'_self');">
					<c:forEach var="i" begin="${startPage }" end="${endPage}">
						<option id = "pageOption" value="imgList?pageNum=${i}&shareType=${shareType}">${i }</option>
					</c:forEach>
				</select>
			</div>			
		</div>

			<!--공유 x 검색 x 리스트 출력  -->
			<c:if test="${not isShare and not isSearch and not empty cList}">
		<div class = "row-lg"  >
			<div class="col  d-flex flex-wrap" style="margin-left: 22px; ">
			
				<c:forEach var="list" items="${cList }">
						<!--  커마 글 -->
						<div class="rounded-3  border border-danger d-flex flex-column align-items-center text-start m-3" style="width: 280px; height: 420px; background-color: rgba(255,0,0,0.1); margin-right: 20px;">
							<div class="row my-3">
								<div class="col my-2">
									<!-- 이미지가 들어가는 자리 -->
									<c:if test="${empty list.conFile }">
										<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}"">
										<img alt="" src="https://via.placeholder.com/240" class="rounded-3" >
										</a>
									</c:if>
									<c:if test="${not empty list.conFile }">
										
										<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}"">
										<img src="upload/${list.conFile}" class="rounded-3" style="width:240px; height:240px;" >
										</a>
									</c:if>
								</div>
							</div>
							<div class="row" >
								<div class=" fw-bold d-flex  justify-content-start" style="width: 240px; height: 30px; font-size:20px; ">
									<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}" id="count">${ list.conTitle}</a>
								</div>
							</div>
							<div class="row my-2">
								<div class=" mb-2 fw-bold d-flex  justify-content-start" style="width: 240px; height: 20px; font-size:18px;">
									${list.userId}
								</div>
							</div>
							<div class="row mb-3 my-1 " style="width: 240px; height: 20px; font-size:15px;">
								<div class="col-2 d-flex text-start  align-items-center">
									<img src="./icon/eye.png" style="width:20px; margin-right: 5px;" >
									<span value="${ list.conCount}" id="conCount" name="conCount">${ list.conCount}</span>
								</div>
								<div class="col-6"></div>
								<div class="col-2 d-flex  align-items-center">
									<img src="./icon/good.png"  style="width:20px; margin-right: 5px;">
									${list.conGood }
								</div>
							</div>
						</div><!--커마끝  -->
				</c:forEach>
			</c:if>
			
			<!--공유 o 검색 x 리스트 출력  -->
			<c:if test="${isShare and not isSearch and not empty cList}">
			<div class = "row-lg"  >
			<div class="col  d-flex flex-wrap" style="margin-left: 22px; ">
				<c:forEach var="list" items="${cList }">
						<!--  커마 글 -->
						<div class="rounded-3  border border-danger d-flex flex-column align-items-center text-start m-3" style="width: 280px; height: 420px; background-color: rgba(255,0,0,0.1); margin-right: 20px;">
							<div class="row my-3">
								<div class="col my-2">
									<!-- 이미지가 들어가는 자리 -->
									<c:if test="${empty list.conFile }">
										<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}&shareType=${shareType}">
										<img alt="" src="https://via.placeholder.com/240" class="rounded-3" >
										</a>
									</c:if>
									<c:if test="${not empty list.conFile }">
										
										<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}&shareType=${shareType}">
										<img src="upload/${list.conFile}" class="rounded-3" style="width:240px; height:240px;" >
										</a>
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class=" fw-bold d-flex  justify-content-start" style="width: 240px; height: 30px; font-size:20px; ">
									<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}&shareType=${shareType}">${ list.conTitle}</a>
								</div>
							</div>
									<div class="row my-2">
								<div class=" mb-2 fw-bold d-flex  justify-content-start" style="width: 240px; height: 20px; font-size:18px;">
									${list.userId}
								</div>
							</div>
							<div class="row mb-3 my-1 " style="width: 240px; height: 20px; font-size:15px;">
								<div class="col-2 d-flex text-start  align-items-center">
									<img src="./icon/eye.png" style="width:20px; margin-right: 5px;" >
									<span value="${ list.conCount}" id="conCount" name="conCount">${ list.conCount}</span>
								</div>
								<div class="col-6"></div>
								<div class="col-2 d-flex  align-items-center">
									<img src="./icon/good.png"  style="width:20px; margin-right: 5px;">
								</div>
							</div>
						</div><!--커마끝  -->
				</c:forEach>
			</c:if>
			
			<!--검색 했을때 리스트 출력  -->
			<c:if test="${not isShare and isSearch and not empty cList}">
			<div class = "row-lg"  >
			<div class="col  d-flex flex-wrap" style="margin-left: 22px; ">
				<c:forEach var="list" items="${cList }">
						<!--  커마 글 -->
						<div class="rounded-3  border border-danger d-flex flex-column align-items-center text-start m-3" style="width: 280px; height: 420px; background-color: rgba(255,0,0,0.1); margin-right: 20px;">
							<div class="row my-3">
								<div class="col my-2">
									<!-- 이미지가 들어가는 자리 -->
									<c:if test="${empty list.conFile }">
										<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}&type=${type}&keyword=${keyword}">
										<img alt="" src="https://via.placeholder.com/240" class="rounded-3" >
										</a>
									</c:if>
									<c:if test="${not empty list.conFile }">
										
										<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}&type=${type}&keyword=${keyword}">
										<img src="upload/${list.conFile}" class="rounded-3" style="width:240px; height:240px;" >
										</a>
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class=" fw-bold d-flex  justify-content-start" style="width: 240px; height: 30px; font-size:20px; ">
									<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}&type=${type}&keyword=${keyword}">${ list.conTitle}</a>
								</div>
							</div>
									<div class="row my-2">
								<div class=" mb-2 fw-bold d-flex  justify-content-start" style="width: 240px; height: 20px; font-size:18px;">
									${list.userId}
								</div>
							</div>
							<div class="row mb-3 my-1 " style="width: 240px; height: 20px; font-size:15px;">
								<div class="col-2 d-flex text-start  align-items-center">
									<img src="./icon/eye.png" style="width:20px; margin-right: 5px;" >
									<span value="${ list.conCount}" id="conCount" name="conCount">${ list.conCount}</span>
								</div>
								<div class="col-6"></div>
								<div class="col-2 d-flex  align-items-center">
									<img src="./icon/good.png"  style="width:20px; margin-right: 5px;">
								</div>
							</div>
						</div><!--커마끝  -->
				</c:forEach>
			</c:if>
			<!-- 공유한 검색 했을때 리스트 출력  -->
			<c:if test="${ isShare and isSearch and not empty cList}">
			<div class = "row-lg"  >
			<div class="col  d-flex flex-wrap" style="margin-left: 22px; ">
				<c:forEach var="list" items="${cList }">
						<!--  커마 글 -->
						<div class="rounded-3  border border-danger d-flex flex-column align-items-center text-start m-3" style="width: 280px; height: 420px; background-color: rgba(255,0,0,0.1); margin-right: 20px;">
							<div class="row my-3">
								<div class="col my-2">
									<!-- 이미지가 들어가는 자리 -->
									<c:if test="${empty list.conFile }">
										<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}&type=${type}&keyword=${keyword}&shareType=${shareType}">
										<img alt="" src="https://via.placeholder.com/240" class="rounded-3" >
										</a>
									</c:if>
									<c:if test="${not empty list.conFile }">
										
										<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}&type=${type}&keyword=${keyword}&shareType=${shareType}">
										<img src="upload/${list.conFile}" class="rounded-3" style="width:240px; height:240px;" >
										</a>
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class=" fw-bold d-flex  justify-content-start" style="width: 240px; height: 30px; font-size:20px; ">
									<a class="link-dark text-decoration-none" href="ListDetail?no=${list.contentNo}&pageNum=${currentPage}&type=${type}&keyword=${keyword}&shareType=${shareType}">${ list.conTitle}</a>
								</div>
							</div>
									<div class="row my-2">
								<div class=" mb-2 fw-bold d-flex  justify-content-start" style="width: 240px; height: 20px; font-size:18px;">
									${list.userId}
								</div>
							</div>
							<div class="row mb-3 my-1 " style="width: 240px; height: 20px; font-size:15px;">
								<div class="col-2 d-flex text-start  align-items-center">
									<img src="./icon/eye.png" style="width:20px; margin-right: 5px;" >
									<span value="${ list.conCount}" id="conCount" name="conCount">${ list.conCount}</span>
								</div>
								<div class="col-6"></div>
								<div class="col-2 d-flex  align-items-center">
									<img src="./icon/good.png"  style="width:20px; margin-right: 5px;">
								</div>
							</div>
						</div><!--커마끝  -->
				</c:forEach>
			</c:if>
			
			
			
			<!--  게시판 내용물이 없을때 -->
			<!-- 검색 요청 x 게시글이 비어있을때 -->
			<c:if test="${not isSearch and empty cList }">
				<div class= "row">
					<div class= "col text-center">
						게시글이 없습니다.
					</div>
				</div>
			</c:if>
			<!-- 검색 요청 o 게시글이 비어있을때 -->
			<c:if test="${isSearch and empty cList }">
				<div class= "row">
					<div class= "col text-center">
						${keyword} 검색 결과가 없습니다.
					</div>
				</div>
			</c:if>
			<!-- 공유 요청 o 게시글이 비어있을때 -->
			<c:if test="${isShare and empty cList }">
				<div class= "row">
					<div class= "col text-center">
						공유게시물이 없습니다.
					</div>
				</div>
			</c:if>
			<!-- 공유 요청 o 검색 o 게시글이 비어있을때 -->
			<c:if test="${isShare and  isSearch and empty cList }">
				<div class= "row">
					<div class= "col text-center">
							${keyword} 검색 결과의 공유게시물이 없습니다.
					</div>
				</div>
			</c:if>
			</div>
		</div>

		<!-- 페이징 부분  -->
		
		<!-- 검색일때 공유 x-->
		<c:if test="${not isShare and  isSearch}">
			<div class="row">
			<div class="col">
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<c:if test="${startPage>pageGroup}">
							<li class="page-item"><a class="page-link" href="imgList?pageNum=${startPage - pageGroup}&type=${type}&keyword=${keyword}">Prev</a></li>
						</c:if>
						
						<c:forEach var="i" begin="${startPage }" end="${endPage}">
							<!-- 현재페이지인경우 -->
							<c:if test= "${i == currentPage }">
							<li class="page-item active"><a class="page-link" href="imgList?pageNum=${startPage - pageGroup}&type=${type}&keyword=${keyword}">${i}</a></li>
							</c:if>
							<c:if test="${i!=currentPage}">
							<li class="page-item"><a class="page-link" href="imgList?pageNum=${i}&type=${type}&keyword=${keyword}">${i}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${endPage<pageCount}">
							<li class="page-item"><a class="page-link" href="imgList?pageNum=${startPage + pageGroup}&type=${type}&keyword=${keyword}">next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
		</c:if>
		<!--공유 검색일때 -->
		<c:if test="${isShare and isSearch}">
			<div class="row">
			<div class="col">
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<c:if test="${startPage>pageGroup}">
							<li class="page-item"><a class="page-link" href="imgList?pageNum=${startPage - pageGroup}&type=${type}&keyword=${keyword}&shareType=${shareType}">Prev</a></li>
						</c:if>
						
						<c:forEach var="i" begin="${startPage }" end="${endPage}">
							<!-- 현재페이지인경우 -->
							<c:if test= "${i == currentPage }">
							<li class="page-item active"><a class="page-link" href="imgList?pageNum=${i}&type=${type}&keyword=${keyword}&shareType=${shareType}">${i}</a></li>
							</c:if>
							
							<c:if test="${i!=currentPage}">
							<li class="page-item"><a class="page-link" href="imgList?pageNum=${i}&type=${type}&keyword=${keyword}&shareType=${shareType}">${i}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${endPage<pageCount}">
							<li class="page-item"><a class="page-link" href="imgList?pageNum=${startPage + pageGroup}&type=${type}&keyword=${keyword}&shareType=${shareType}">next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
		</c:if>
		<!-- 일판일때 -->
		<c:if test="${not isShare and not isSearch}">
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
		</c:if>
		<!-- 공유일때 -->
		<c:if test="${ isShare and not isSearch}">
			<div class="row">
			<div class="col">
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<c:if test="${startPage>pageGroup}">
							<li class="page-item"><a class="page-link" href="imgList?shareType=${shareType}&pageNum=${startPage - pageGroup}">Prev</a></li>
						</c:if>
						
						<c:forEach var="i" begin="${startPage }" end="${endPage}">
							<!-- 현재페이지인경우 -->
							<c:if test= "${i == currentPage }">
							<li class="page-item active"><a class="page-link" href="imgList?shareType=${shareType}&pageNum=${i}">${i}</a></li>
							</c:if>
							
							<c:if test="${i!=currentPage}">
							<li class="page-item"><a class="page-link" href="imgList?shareType=${shareType}&pageNum=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${endPage<pageCount}">
							<li class="page-item"><a class="page-link" href="imgList?shareType=${shareType}&pageNum=${startPage + pageGroup}">next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
		</c:if>
		<!--푸터부분-->
	</div><!-- 컨트롤러 끝 -->
	<script src="bootstrap/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
	    function updateShareType(checkbox) {
	        var shareType = checkbox.value === 'Y' ? '' : 'Y'; // 체크됐을 때 'Y', 아니면 빈 문자열로 설정
	        var href = window.location.href; // 현재 URL 가져오기
	        var separator = href.indexOf('?') !== -1 ? '&' : '?'; // 주소에 이미 파라미터가 있는지 확인
	        var ref = href.replace(/&shareType=(?:[^&]*)/, ''); // 기존의 shareType 값 제거
	        ref += separator + 'shareType=' + shareType; // 변경된 URL에 새로운 shareType 값 추가
	        window.location.href = ref; // 변경된 URL로 이동
	    }
	</script>
</body>
</html>