<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>커마 상세보기</title>
<link href="bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row my-5" style="background-color:gray; height: 50px;"">
			<div  class="col-2">
				${content.userId }
			</div>
			<div  class="col-8 text-center">
				<fmt:formatDate value="${content.conReDate }" pattern="yy-MM-dd HH:mm:ss"/>
			</div>
			<div  class="col-2">
				${content.conCount }
			</div>
		</div>
		<div class="row my-5">
			<div class="col">
				${content.conShare }
			</div>
			<div class="col">
				${content.conGood }
			</div>
		</div>
		<div class="row my-5">
			<div class="col">
				<h2 class="text-center"> ${content.conTitle }</h2>
			</div>
		</div>
		<div class="row my-5">
			<div class="col">
				<pre>${content.conText }</pre>
			</div>
		</div>
		<div class="row my-5">
			<div class="col">
				<button type="button" class="btn btn-primary"><img src="./icon/good.png" Style="width:12px">&nbsp;&nbsp;${content.conGood}</button>
				<button type="button" class="btn btn-danger"><img src="./icon/bad.png" Style="width:12px">&nbsp;&nbsp;${content.conBad}</button>
			</div>
		</div>
	</div>
<script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>