<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>🌎 우주최강 2팀 🌎</title>
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,300,700,900"
	rel="stylesheet">
<style>
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
	font-weight: 400;
	padding: 15px 25px;
	/**/
	position: relative;
	display: block;
	text-decoration: none;
	text-transform: uppercase;
}
</style>
<link href="bootstrap/bootstrap.min.css" rel="stylesheet">

				<ul
					class="d-flex menu align-center expanded text-center SMN_effect-15 justify-content-center"
					style="list-style: none">
					<li><a href="" class="fw-bold link-light text-decoration-none" >🦊 양은정</a></li>
					<li><a href="" class="fw-bold link-light text-decoration-none">️🐻‍❄ 이현학</a></li>
					<li><a href="" class="fw-bold link-light text-decoration-none">🐹 우황희</a></li>
					<li><a href="" class="fw-bold link-light text-decoration-none">🐭 이형철</a></li>
				</ul>

	<script src="bootstrap/bootstrap.bundle.min.js"></script>
