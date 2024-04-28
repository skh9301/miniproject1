<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>글쓰기</title>
<link href="bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="js/summernote-0.8.18-dist/formcheck.js"></script> 
</head>
<body>
	<div class="container">
		<div class="row my">
			<div class= "col">
				<h2 class="text-center">글쓰기</h2>
			</div>
		</div>
		<form name="updateForm" id="updateForm" action="updateProcess" method="post" ${not empty board.file1 ? "" : "enctype='multipart/form-data'"}>
			<input type="hidden" name="no" id="no" value="${ content.contentNo}"/>
					<input type="hidden" name="userId" id="userId" value="${content.userId }">
					<input type="hidden" name="pageNum" id="pageNum" value="${pageNum }">
					<input type="hidden" name="type" id="type" value="${type }">
					<input type="hidden" name="keyword" id="keyword" value="${keyword }">
					<input type="hidden" name="shareType" id="shareType" value="${shareType }">
			<div class= "row my-3 bg-warning-subtle " style="width: 100%; height: 50px;">
			<div class="row  bg-warning mx-0" style="width: 100%; height:5px"></div>
			<div class="row d-flex align-items-center mx-0" style="height:45px;">
				
				<div class="col">
					상시 공유
				  <input class="form-check-input mx-2" name="UconShare"type="checkbox" value="on" id="flexCheckDefault">
				  <label class="form-check-label" for="flexCheckDefault">
				</div>
				<div class="col-6 d-flex justify-content-center">
					제 목 : &nbsp;&nbsp;<input type="text" id="Utitle" name="Utitle" style="height: 20px;" value="${content.conTitle }">
				</div>
				<div class="col d-flex justify-content-end">
				작성자 : ${member.nickName}
				</div>
			</div>
		</div>
		
		<!-- content  -->
		<div class="row">
				<label for="content" class="form-label mx-4">내 용</label>
			<div class= "col d-flex justify-content-center">
					    <textarea class="form-control" name="Ucontext" id="Ucontext" rows="10">${content.conText }</textarea>
			</div>
		</div>
		<c:if test="${empty  content.conFile}">
		<div class="row my-4">
			<div class= "col mx-4 d-flex justify-content-start">
				<label for="WconFile" class="form-label"></label>
					    <input type="file" class="form-control" name="UconFile"  id="UconFile" value="${content.conFile}">
			</div>
		</div>
		</c:if>
		
		<div class="row my-4 ">
			<div class="col d-flex justify-content-center">
					<button class="btn btn-primary mx-4" type="submit" id="update" >수정하기</button>
					 <button class="btn btn-danger mx-4" type="button" onclick="location.href='imgList?pageNum=${pageNum}&type=${type}&keyword=${keyword}&shareType=${shareType}'">작성취소</button>
			</div>
		</div>
		</form>
	</div>
	<script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>