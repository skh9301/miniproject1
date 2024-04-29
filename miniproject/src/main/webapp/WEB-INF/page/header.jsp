<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
					<h2 class="fs-1 text fw-bold text-center"> <a href="imgList" class="fw-bold link-light text-decoration-none">  커마 자랑 공간</a></h2>
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${not empty id}">
		<div class="header  rounded-3 text-bg-secondary p-3"  style="border :1px solid">
			<div class="row my-3">
				<div class="col d-flex justify-content-end mx-5 my-2">
					 <a href="logoutPro" id="logOut" class="fw-bold link-light text-decoration-none">  회원정보 수정</a> &nbsp;| &nbsp;<a href="logoutPro" id="logOut" class="fw-bold link-light text-decoration-none">로그아웃</a>
				</div>
			</div>
			<div class="row my-3">
			<div class="col">
				<h2 class="fs-1 text fw-bold text-center"> <a href="imgList" class="fw-bold link-light text-decoration-none">커마 자랑 공간</a></h2>
			</div>
		</div>
		<div class="row">
			<div class="col  d-flex justify-content-end mx-5 my-2">
				${nick}님 어서오세요 ~~
			</div>
		</div>
		</div>
		</c:if>
