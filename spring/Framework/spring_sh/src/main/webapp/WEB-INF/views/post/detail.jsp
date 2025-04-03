<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.js"></script>
</head>
<body>
	
	<c:choose>
		<c:when test="${post ne null}">
			<h1>게시글 상세</h1>
			<div>
				<div class="form-group mt-3">
					<label class="form-label">게시판</label>
					<input type="text" class="form-control" value="${post.po_bo_name }" readonly>
				</div>
				<div class="form-group mt-3">
					<label class="form-label">제목</label>
					<input type="text" class="form-control" value="${post.po_title}" readonly>
				</div>
				<div class="form-group mt-3">
					<label class="form-label">작성자</label>
					<input type="text" class="form-control"value="${post.po_me_id}" readonly>
				</div>
				<div class="form-group mt-3">
					<label for="title" class="form-label">작성일</label>
					<input type="text" class="form-control" value="<fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss" />" readonly>
				</div>
				<div class="form-group mt-3">
					<label for="title" class="form-label">조회수</label>
					<input type="text" class="form-control" value="${post.po_view}" readonly>
				</div>
				<div class="form-group mt-3 d-flex justify-content-center" id="btns">
					<button class="btn btn<c:if test="${like.li_state ne 1}">-outline</c:if>-success btn-up" data-state="1">좋아요(${post.po_up})</button>
					<button class="btn btn<c:if test="${like.li_state ne -1}">-outline</c:if>-danger ml-3 btn-down" data-state="-1">싫어요(${post.po_down})</button>
				</div>
				<div class="form-group mt-3">
					<label for="content" class="form-label">내용</label>
					<div class="form-control" id="content" style="min-height: 400px;">${post.po_content }</div>
				</div>
				<c:if test="${list.size() ne 0}">
					<div class="form-group">
						<label>첨부파일</label>
						<c:forEach items="${list }" var="file">
							<a class="form-control" href="<c:url value="/download${file.fi_name}"/>" download="${file.fi_ori_name}">${file.fi_ori_name }</a>
						</c:forEach>							
					</div>
				</c:if>
			</div>
		</c:when>
		<c:otherwise>
			<h3>등록되지 않거나 삭제된 게시글입니다.</h3>		
		</c:otherwise>
	</c:choose>
	<div class="d-flex justify-content-between">
		<a href="<c:url value="/post/list"/>" class="btn btn-outline-success">목록</a>
		<c:if test="${user.me_id eq post.po_me_id }">
			<div class="btns">
				<a href="<c:url value="/post/update/${post.po_num}"/>" class="btn btn-outline-info">수정</a>
				<a href="<c:url value="/post/delete/${post.po_num}"/>" class="btn btn-outline-danger">삭제</a>
			</div>
		</c:if>
	</div>
	<h3>댓글</h3>
	<div class="comment-container">
	
	</div>
	
	<!-- 댓글 목록 조회 -->
	<script type="text/javascript">
		var cri = {
				page : 1,
				search : ${post.po_num}
		}
		function getCommentList(cri){
			//ajax로 댓글 리스트를 가져와서 화면에 출력
			$.ajax({
				async : true, //비동기 : true(비동기), false(동기)
				url : '<c:url value="/comment/list"/>', 
				type : 'post', 
				data : JSON.stringify(cri), 
				contentType : "application/json; charset=utf-8",
				success : function (data){
					$(".comment-container").html(data);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		}
		
		getCommentList(cri);
	</script>
	
	<script type="text/javascript">
		$(document).on("click", ".btn-up, .btn-down", function(e){
			
			if(${user == null}){
				if(confirm("로그인이 필요한 페이지 입니다.\n로그인 페이지로 이동하시겠습니까?")){
					location.href="<c:url value="/login"/>";
				}
				return;
			}
			let state = $(this).data("state");
			let num = "${post.po_num}";
			
			let like = {
				li_po_num : num,
				li_state : state
			}
			$.ajax({
				async : true, //비동기 : true(비동기), false(동기)
				url : '<c:url value="/post/like"/>', 
				type : 'post',//json으로 보낼때는 무조건 post 
				data : JSON.stringify(like), 
				contentType : "application/json; charset=utf-8",
				success : function (data){
					switch(data){
					case -1:
						alert("싫어요를 눌렀습니다.")
						$("#btns").load(location.href + " #btns>*");
						break;
					case 1:
						alert("좋아요를 눌렀습니다.")
						$("#btns").load(location.href + " #btns>*");
						break;
					case 0:
						alert((state == 1 ? "좋아요" : "싫어요") + "를 취소했습니다.")
						$("#btns").load(location.href + " #btns>*");
						break;
					default:
						alert("오류");
					}
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	</script>
	
</body>
</html>