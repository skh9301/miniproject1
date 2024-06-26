
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/summernote-0.8.18-dist/formcheck.js"></script>
<title>커마 상세보기</title>
<link href="bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-lg" id="fabio1"
		style="width: 1390px; height: 1400px;">
		<div class="row d-flex justify-content-center">
			<img src="./icon/배너2투명도.png"
				class="z-n1 position-absolute p-5 rounded-3"
				style="width: 1390px; background-repeat: no-repeat; background-position: center center; height: 1400px;">
		</div>
		<div class="my-4"></div>
		<!-- header  -->
		<%@ include file="../page/header.jsp"%>
		<!--center  -->
		<form name="checkForm" id="checkForm">
			<input type="hidden" name="no" id="no" value="${ content.contentNo}" />
			<input type="hidden" name="userId" id="userId"
				value="${content.userId }"> <input type="hidden"
				name="pageNum" id="pageNum" value="${pageNum }"> <input
				type="hidden" name="type" id="type" value="${type }"> <input
				type="hidden" name="keyword" id="keyword" value="${keyword }">
			<input type="hidden" name="shareType" id="shareType"
				value="${shareType }">

			<div class="row  bg-warning-subtle "
				style="width: 1295px; height: 50px; margin-left: 0px">
				<div class="row  bg-warning mx-0" style="width: 100%; height: 5px"></div>
				<div class="row d-flex align-items-center mx-0"
					style="height: 45px;">

					<div class="col">${member.nickName }</div>
					<div class="col-6 d-flex justify-content-center">
						<fmt:formatDate value="${content.conReDate }"
							pattern="yy-MM-dd HH:mm:ss" />
					</div>
					<div class="col d-flex justify-content-end">
						<%-- <input type="text" value="${nick}"> --%>
						조회수 : ${content.conCount }
					</div>
				</div>
			</div>
			<div class="row my-2 mx-0 d-flex justify-content-between">
				<div class="col-2 text-end">${content.conShare.equals("Y")? "상시공유" : "공유안함" }
				</div>
				<div class="col-8"></div>
				<div class="col-2 ">추천수 : &nbsp;&nbsp;${content.conGood }</div>
			</div>
			<div class="row">
				<div class="col ">
					<h2 class="text-center fs-1 fw-bold text-dark">[커스텀마이징]
						${content.conTitle }</h2>
				</div>
			</div>
			<div class="row-lg my-5">
				<div class="col d-flex justify-content-center">
					<c:if test="${not empty content.conFile }">
						<img src="upload/${content.conFile }" style="width: 500px;">
					</c:if>
				</div>
			</div>
			<div class="row-lg my-5">
				<div class="col d-flex justify-content-center">
					<pre Class="w-60 p-3 fs-3">${content.conText }</pre>
				</div>
			</div>
			<div class="row my-5 ">
				<div class="col  d-flex justify-content-evenly">
					<input type="button" class="btn btn-primary btn-lg" name="conGood"
						id="conGood" value="${content.conGood}"> <input
						type="button" class="btn btn-danger btn-lg" name="conBad"
						id="conBad" value="${content.conBad}">

				</div>
			</div>
			<div class="row my-6 ">
				<div class="col mx-5 d-flex justify-content-end">
					<c:if test="${islogIn}">
						<input class="btn btn-warning" type="button" id="detailUpdate"
							value="수정하기" />
					&nbsp;&nbsp;<input class="btn btn-danger" type="button"
							id="detailDelete" value="삭제하기" />
					</c:if>
					&nbsp;&nbsp; <input class="btn btn-primary" type="button"
						value="목록보기"
						onclick="location.href='imgList?pageNum=${pageNum}&type=${type}&keyword=${keyword}&shareType=${shareType}'" />

				</div>
			</div>
	</div>
	</form>
	<script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>