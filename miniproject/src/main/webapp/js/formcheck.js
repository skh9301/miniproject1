$(function() {
	
	
		
		

		$("#sign").on("click", function(){
			if($("#id").val().trim().length<=0){
				alert("아이디를 입력하세요");
				return false;
			};
			if($("#pass").val().trim().length<=0){
				alert("비밀번호를 입력하세요");
				return false;
			};
			if($("#nick").val().trim().length<=0){
				alert("별명을 입력하세요");
				return false;
			};
			if($("#phone").val().trim().length<=0){
				alert("휴대폰 번호를 입력하세요");
				return false;
			};
			if($("#mail").val().trim().length<=0){
				alert("이메일을 입력하세요");
				return false;
			};
		});
		
		$("#log").on("click", function(){
			if($("#LogId").val().trim().length<=0){
				alert("아이디를 입력하세요");
				return false;
			};
			if($("#LogPass").val().trim().length<=0){
				alert("비밀번호를 입력하세요");
				return false;
			};
			
		});
		
		//업데이트 버튼 눌렀을때
		$("#detailUpdate").on("click", function(){
			$("#checkForm").attr("action","updateForm");
			$("#checkForm").attr("method","post");
			$("#checkForm").submit();
		})


		// 글 삭제하는 버틍
		$("#detailDelete").on("click", function(){
			$("#checkForm").attr("action","deleteProcess");
			$("#checkForm").attr("method","post");
			$("#checkForm").submit();
		})
});