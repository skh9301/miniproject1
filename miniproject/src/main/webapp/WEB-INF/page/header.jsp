<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<!-- 헤더부분-->
				<link
	href="https://fonts.googleapis.com/css?family=Lato:400,300,700,900"
	rel="stylesheet">
	<head>
	<style>
		#fabio {
			background:url("icon/배너3.jpg");
			background-repeat: no-repeat;
			background-size: 1300px 300px;
			background-position: center center;
			width: 100%;
			height: 300px;
			border: 1px soild;
			}
			
.SMN_effect-15 a:before, .SMN_effect-15 a:after {
	display: inline-block;
	opacity: 0;
	-webkit-transition: -webkit-transform 0.3s, opacity 0.2s;
	-moz-transition: -moz-transform 0.3s, opacity 0.2s;
	transition: transform 0.3s, opacity 0.2s;
}

.SMN_effect-15 a:before {
	margin-right: 10px;
	content: '[';
	-webkit-transform: translateX(20px);
	-moz-transform: translateX(20px);
	transform: translateX(20px);
}

.SMN_effect-15 a:after {
	margin-left: 10px;
	content: ']';
	-webkit-transform: translateX(-20px);
	-moz-transform: translateX(-20px);
	transform: translateX(-20px);
}

.SMN_effect-15 a:hover:before, .SMN_effect-15 a:hover:after,
	.SMN_effect-15 a:focus:before, .SMN_effect-15 a:focus:after {
	opacity: 1;
	-webkit-transform: translateX(0px);
	-moz-transform: translateX(0px);
	transform: translateX(0px);
}

.menu a {
	color: rgba(0, 0, 0, 0.8);
	font-family: Lato;
	font-size: 17pt;
	font-weight: 400px;
	margin-top:10px;
	/**/
	position: relative;
	display: block;
	text-decoration: none;
	text-transform: uppercase;
}
	</style>
	</head>
	
	<c:if test="${empty id}">
		<div class="header  rounded-3 "  id = "fabio" style:"border:1px solid">
		<!-- teamheader  -->
		
				<ul
					class="d-flex menu align-center expanded text-center SMN_effect-15 justify-content-center m-0 p-0"
					style="list-style: none; ">
					<li><a href="http://192.168.0.70:8080/JSPStudyBBS902/boardMain" class="fw-bold link-light text-decoration-none" >🦊 양은정</a></li>
					<li><a href="http://192.168.0.6:8080/miniProject01/management" class="fw-bold link-light text-decoration-none">🐻 이현학</a></li>
					<li><a href="http://192.168.0.17:8080/Challenge/postMain" class="fw-bold link-light text-decoration-none">🐹 우황희</a></li>
					<li><a href="http://192.168.0.9:9000/Challenge/postMain" class="fw-bold link-light text-decoration-none">🐭 이형철</a></li>
				</ul>

			<div class="row" >
				<div class="col d-flex justify-content-end mx-5">
					<a href="logForm" class="fw-bold link-light text-decoration-none">로그인</a>&nbsp; |  &nbsp;<a href="signForm" class="fw-bold link-light text-decoration-none">회원가입</a>
				</div>
			</div>
			<div class="row" style ="margin-top: 40px;">
				<div class="col">
					<h2 class="text fw-bold text-center" style="text-size:40px;"> <a href="imgList" class="fw-bold link-light text-decoration-none">커마 자랑 공간</a></h2>
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${not empty id}">
		<div class="header  rounded-3 "  id = "fabio" >
		<!-- teamheader  -->
		
				<ul
					class="d-flex menu align-center expanded text-center SMN_effect-15 justify-content-center m-0 p-0"
					style="list-style: none; ">
					<li><a href="http://192.168.0.70:8080/JSPStudyBBS902/boardMain" class="fw-bold link-light text-decoration-none" >🦊 양은정</a></li>
					<li><a href="http://192.168.0.6:8080/miniProject01/management" class="fw-bold link-light text-decoration-none">🐻‍ 이현학</a></li>
					<li><a href="http://192.168.0.17:8080/Challenge/postMain" class="fw-bold link-light text-decoration-none">🐹 우황희</a></li>
					<li><a href="http://192.168.0.9:9000/Challenge/postMain" class="fw-bold link-light text-decoration-none">🐭 이형철</a></li>
				</ul>

			<div class="row" >
				<div class="col d-flex justify-content-end mx-4">
					 <a href="signPassForm" class="fw-bold link-light text-decoration-none">  회원정보 수정</a> &nbsp;| &nbsp;<a href="logoutPro" id="logOut" class="fw-bold link-light text-decoration-none">로그아웃</a>
				</div>
			</div>
		<div class="row" style ="margin-top: 40px;">
				<div class="col">
				<h2 class="text fw-bold text-center" style="text-size:40px;"> <a href="imgList" class="fw-bold link-light text-decoration-none">커마 자랑 공간</a></h2>
			</div>
		</div>
		<div class="row">
			<div class="col  d-flex justify-content-end mx-5 text-light  fw-bold" style ="margin-top: 110px;">
				${nick}님 어서오세요 ~~
			</div>
		</div>
		</div>
		</c:if>
