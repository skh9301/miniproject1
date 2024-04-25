<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인</title>
<link href="bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form name="logForm" id="logForm" action="imgList" method="post">
		<div class="row">
			<div class="col">
				<h2 class="text-center">로그인</h2>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<span>아이디 :</span>
				<input type="text" name="id" id="id" class="form-control">
			</div>
		</div>
		<div class="row">
			<div class="col">
				<span>비밀번호 :</span>
				<input type="password" name="pass" id="pass" class="form-control">
			</div>
		</div>
		<div class="row my-4">
			<div class="col d-grid gap-2">
			  <button class="btn btn-primary" type="submit" id="sign" >로그인</button>
			  <button class="btn btn-primary" type="button" onclick.href="logForm">취소</button>
			</div>
		</div>
		</form>
	</div>
	<script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>