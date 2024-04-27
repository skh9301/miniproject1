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
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="js/formcheck.js"></script> 
</head>
<body>
	<div class="container">
		<div class="row my">
			<div class= "col">
				<h2 class="text-center">글쓰기</h2>
			</div>
		</div>
		<form name="writeForm" id="writeForm" action="writeProcess" method="post">
		<div class= "row my-3 bg-warning-subtle d-flex justify-content-center" style="width: 100%; height: 50px;">
			<div class="mw-100 bg-warning " style="width: 200%;"></div>
			<div class="col m-3">
				상시 공유
				  <input class="form-check-input mx-2" name="WconShare"type="checkbox" value="on" id="flexCheckDefault">
				  <label class="form-check-label" for="flexCheckDefault">
				  </label>
			</div>
			<div class="col-6 my-3 d-flex justify-content-center">
				제 목 : &nbsp;&nbsp;<input type="text" id="Wtitle" name="Wtitle" style="height: 20px;">
			</div>
			<div class="col m-3 d-flex justify-content-end">
			<%-- <input type="text" value="${nick}"> --%>
			${nick }
			</div>
		</div>
		
		<!-- content  -->
		<div class="row">
			<div class= "col d-flex justify-content-center">
				<input type="text" name="Wcontext">
			</div>
		</div>
		<div class="row">
			<div class= "col d-flex justify-content-center">
				<input type="file" name="WconFile">
			</div>
		</div>
		
		
		<div class="row">
			<div class="col">
					<button class="btn btn-primary" type="submit" id="write" >작성등록</button>
					 <button class="btn btn-primary" type="button" onclick="location.href='imgList'">작성취소</button>
			</div>
		</div>
		</form>
	</div>
	<script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>