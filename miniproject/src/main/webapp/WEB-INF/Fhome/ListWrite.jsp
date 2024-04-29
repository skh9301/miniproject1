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
  <link href="bootstrap/bootstrap.min.css" rel="stylesheet" >
    <script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/summernote-0.8.18-dist/formcheck.js"></script> 
<!--  섬머-->

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="js/summernote-0.8.18-dist/summernote.min.css" rel="stylesheet">
<script src="js/summernote-0.8.18-dist/summernote.min.js"></script>
</head>
<body>
	<div class="container">
		<!-- header  -->
		<%@ include file="../page/header.jsp"%>
		<!--center  -->
		<div class="row my">
			<div class= "col">
				<h2 class="text-center">글쓰기</h2>
			</div>
		</div>
		<form name="writeForm" id="writeForm"  enctype="multipart/form-data" action="writeProcess" method="post" >
			<input  type="hidden" name="pageNum" value="${pageNum }">
		<div class= "row my-3 bg-warning-subtle " style="width: 100%; height: 50px;">
			<div class="row  bg-warning mx-0" style="width: 100%; height:5px"></div>
			<div class="row d-flex align-items-center mx-0" style="height:45px;">
				
				<div class="col">
					상시 공유
				  <input class="form-check-input mx-2" name="WconShare"type="checkbox" value="on" id="flexCheckDefault">
				</div>
				<div class="col-6 d-flex justify-content-center">
					제 목 : &nbsp;&nbsp;<input type="text" id="Wtitle" name="Wtitle" style="height: 26px;">
				</div>
				<div class="col d-flex justify-content-end">
				<%-- <input type="text" value="${nick}"> --%>
				작성자 : ${nick }
				</div>
			</div>
		</div>
		<!-- content  -->
		<div class="row my-2">
				<label for="content" class="form-label mx-5">내 용</label>
		</div>
			<div class= "row d-flex justify-content-center">
				     <textarea class="form-control" name="Wcontext" id="Wcontext" rows="10"></textarea>
				</div>
		<div class="row my-4">
			<div class= "col mx-4 d-flex justify-content-start">
				<label for="WconFile" class="form-label"></label>
					    <input type="file" class="form-control" name="WconFile"  id="WconFile" >
			</div>
		</div>
		<div class="row my-4 ">
			<div class="col d-flex justify-content-center">
					<button class="btn btn-primary mx-4" type="submit" >작성등록</button>
					 <button class="btn btn-danger mx-4" type="button" onclick="location.href='imgList?pageNum=${pageNum}&type=${type}&keyword=${keyword}&shareType=${shareType}'">작성취소</button>
			</div>
		</div>
		</form>
	</div>
	 <script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>