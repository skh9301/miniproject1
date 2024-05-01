<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>
<link href="bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/summernote-0.8.18-dist/formcheck.js"></script> </head>
<body>
	<div class="container-sm border border-primary rounded-3" style="margin-top: 7%;  width: 800px;">
		<form name="signForm" id="signForm" action="signUpdateProcess" method="post">
		<div class="row my-2">
			<div class="col">
				<h2 class="text-center">회원수정</h2>
			</div>
		</div>
		<div class="row m-2">
			<div class="col">
				<span>비밀번호 :</span>
				<input type="password" name="signpass" id="signpass" class="form-control">
			</div>
		</div>
		<div class="row m-2">
			<div class="col">
				<span>닉네임 :</span>
				<input type="text" name="nick" id="nick" class="form-control">
			</div>
		</div>
		<div class="row m-2">
			<div class="col">
				<span class="text-center">휴대폰 번호 :</span>
				<input type="tel" name="phone" id="phone" class="form-control">
			</div>
		</div>
		<div class="row m-2">
			<div class="col">
				<span>이메일 :</span>
				<input type="email" name="mail" id="mail" class="form-control">
			</div>
		</div>
		
		<div class="row m-4">
			<div class="col d-grid gap-2">
			  <button class="btn btn-primary" type="submit" id="sign" >수정하기</button>
		</form>
			  <button class="btn btn-primary" type="button" onclick="location.href='imgList'">취소하기</button>
			</div>
		</div>
	</div>
    <script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>