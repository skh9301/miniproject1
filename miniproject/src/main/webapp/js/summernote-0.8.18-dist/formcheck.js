$(function() {
	
$(document).ready(function() {
    // 페이지가 로드될 때 초기값 가져오기
    getInitialCounts();
});

// 좋아요 버튼 클릭 시
$("#conGood").on("click", function(event) {
    event.preventDefault(); // 기본 이벤트(폼 제출) 방지

    var currentGoodCount = parseInt($(this).val()); // 현재 좋아요 개수 가져오기
    var newGoodCount = currentGoodCount + 1; // 새로운 좋아요 개수 계산
    $(this).val(newGoodCount); // 새로운 좋아요 개수로 값 변경

    // HTML에서 no 값 가져오기
    var no = $("#no").val();

    // 포스트 요청 보내기
    $.ajax({
        method: "POST",
        data: { goodCount: newGoodCount, no: no }, // 서버로 전송할 데이터
        url: "/miniproject/ListDetail",
        success: function(response) {
            // 요청이 성공하면 수행할 작업
            console.log("좋아요 수가 성공적으로 업데이트되었습니다.");
        },
        error: function(xhr, status, error) {
            // 요청이 실패하면 수행할 작업
            console.error("AJAX request failed:", status, error);
        }
    });
});

// 싫어요 버튼 클릭 시
$("#conBad").on("click", function(event) {
    event.preventDefault(); // 기본 이벤트(폼 제출) 방지

    var currentBadCount = parseInt($(this).val()); // 현재 싫어요 개수 가져오기
    var newBadCount = currentBadCount + 1; // 새로운 싫어요 개수 계산
    $(this).val(newBadCount); // 새로운 싫어요 개수로 값 변경

    // HTML에서 no 값 가져오기
    var no = $("#no").val();

    // 포스트 요청 보내기
    $.ajax({
        method: "POST",
        data: { badCount: newBadCount, no: no }, // 서버로 전송할 데이터
        url: "/miniproject/ListDetail",
        success: function(response) {
            // 요청이 성공하면 수행할 작업
            console.log("싫어요 수가 성공적으로 업데이트되었습니다.");
        },
        error: function(xhr, status, error) {
            // 요청이 실패하면 수행할 작업
            console.error("AJAX request failed:", status, error);
        }
    });
});

// 초기값을 가져오는 함수
function getInitialCounts() {
    // HTML에서 no 값 가져오기
    var no = $("#no").val();

    // AJAX 요청 보내기
    $.ajax({
        method: "GET",
        url: "/miniproject/GetInitialCounts?no=" + no, // 서버에서 초기값을 가져올 URL
        success: function(response) {
            // 서버에서 가져온 초기값으로 좋아요와 싫어요 버튼의 값을 설정
            $("#conGood").val(response.goodCount);
            $("#conBad").val(response.badCount);
        },
        error: function(xhr, status, error) {
            // 요청이 실패하면 수행할 작업
            console.error("Initial counts request failed:", status, error);
        }
    });
}	
		
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
		
		  
		  //content 쓰기 
	$("#writeForm").on("submit", function() {
		if($("#Wtitle").val().length <= 0) {
			alert("제목이 입력되지 않았습니다.\n제목을 입력해주세요");
			$("#writer").focus();			
			return false;
		}
			if($("#Wcontext").val().length<=0){
				alert("내용을 입력하세요");
				return false;
			};
		});
		
		//업데이트 쓰기 
		$("#updateForm").on("submit", function(){
			if($("#Utitle").val().trim().length<=0){
				alert("제목을 입력하세요");
				return false;
			};
			if($("#Ucontext").val().trim().length<=0){
				alert("내용을 입력하세요");
				return false;
			};
		});
		
		//회원가입창
		$("#signForm").on("submit", function(){
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
		
		$("#logForm").on("submit", function(){
			if($("#LogId").val().trim().length<=0){
				alert("아이디를 입력하세요");
				return false;
			};
			if($("#LogPass").val().trim().length<=0){
				alert("비밀번호를 입력하세요");
				return false;
			};
			
		});
		function updateShareType(checkbox) {
		    var shareType = checkbox.checked ? 'Y' : ''; // 체크 여부에 따라 isShare 값을 설정
		    var links = document.querySelectorAll('.contentLink'); // 모든 링크를 선택
		    for (var i = 0; i < links.length; i++) {
		        var link = links[i];
		        var href = link.getAttribute('href');
		        // href 값에 shareType 파라미터를 추가 또는 제거하여 업데이트
		        if (href.indexOf('&shareType=') !== -1) {
		            href = href.replace(/&shareType=(?:[^&]*)/, '&shareType=' + shareType);
		        } else {
		            href += '&shareType=' + shareType;
		        }
		        link.setAttribute('href', href); // 업데이트된 href 값을 적용
		    }
		}
		
		//summernote
		
		  $(document).ready(function(){
	 
	 	//썸머노트에 값넣기
	   $('#summernote').summernote('code', '<p>가나다</p><p>마바사</p><p>아자차카타파하</p>');
	 
	    //위와 같이 값을 먼저 넣어준 후 초기화를 시킨다. 그럼 아래와 같이 입력이 된다.
	    //초기화
		$('#summernote').summernote({
			height : 400, // set editor height
			minHeight : null, // set minimum height of editor
			maxHeight : null, // set maximum height of editor
			focus : true,
			lang : 'ko-KR' // 기본 메뉴언어 US->KR로 변경
		});
			 
		    //저장버튼 클릭
		    $(document).on('click', '#saveBtn', function () {
		        saveContent();
		      
		    });
		 });
		 
    //데이터 저장
    function saveContent() {
    	
        //값 가져오기
        var summernoteContent = $('#summernote').summernote('code');        //썸머노트(설명)
        console.log("summernoteContent : " + summernoteContent);
		
    }
 	
 	
		
});