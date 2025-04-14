<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
	<h1 class="mt-3">게시글 목록</h1>
	<!-- 게시판 버튼들 추가 -->
	<button class="btn btn-outline-success btn-board" data-num="0">전체</button>
	<c:forEach items="${boardList}" var="board">
		<button class="btn btn-outline-success btn-board" data-num="${board.bo_num }">${board.bo_name}</button>	
	</c:forEach>
	<!-- 검색화면 추가(검색창, 검색 타입, 버튼) -->
	
	<!-- 게시글 목록 보여주는 컨테이너 추가 -->
	<div class="pl-container mt-3 mb-3">
		<!--
		<div class="form-group">
			<div class="form-control input-group" style="min-height: auto; height: auto">
				<img width="100" height="120" src="https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp">
				<div class="ml-3">
					<div>게시글 제목</div>
					<div>작성자 : 홍길동</div>
					<div>작성일 : 2025-04-14</div>
					<div>조회수 : 100</div>
					<div>추천수 : 10</div>
				</div>
			</div>
		</div>
		-->
	</div>
	
	<!-- 더보기 버튼 추가 -->
	
	<script type="text/javascript">
		getPostList(0);
		
		$(".btn-board").click(function (e) {
			let num = $(this).data("num");
			getPostList(num);
		});
		
		function getPostList(num){
			checkBoardBtn(num);
			/*
			비동기 통신으로 서버에 연결하여 빈 문자열로 받는 코드를 작성
			url : /post/list
			method : post
			data : num을 전송
			*/
			$.ajax({
				async : true, //비동기 : true(비동기), false(동기)
				url : '<c:url value="/post/list"/>', 
				type : 'post', 
				data : {num : num},
				success : function (data){
					$(".pl-container").html(data);
					console.log(data);
				}
			});
		};
		
		function checkBoardBtn(num){
			//초기 설정
			$(".btn-board").addClass("btn-outline-success");
			$(".btn-board").removeClass("btn-success");
			//num에 따라 게시판 색상을 변경
			$(".btn-board").each(function(){
				if($(this).data("num")==num){
					$(this).removeClass("btn-outline-success");
					$(this).addClass("btn-success");
				}
			});
		}
	</script>
</body>
</html>
