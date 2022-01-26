<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/comment.js"></script>
</head>
<body>
	<div class="body">
		<c:if test="${board != null}">
			<h1>${board.typeTitle }</h1>
			<div class="form-group">
			  <label>제목</label>
			  <input type="text" class="form-control" readonly value="${board.bd_title}">
			</div>
			<div class="form-group">
			  <label>작성자</label>
			  <input type="text" class="form-control" readonly value="${board.bd_me_id}">
			</div>
			<div class="form-group">
			  <label>작성일</label>
			  <input type="text" class="form-control" readonly value="${board.bd_reg_date_str}">
			</div>
			<div class="form-group">
			  <label>내용</label>
			  <div class="form-control" style="min-height: 400px; height: auto">${board.bd_content}</div>
			</div>
			<div class="form-group">
			  <label>첨부파일</label>
			  <c:forEach items="${fileList}" var="file">
			  	<a href="<%=request.getContextPath()%>/board/download?fileName=${file.fi_name}" class="form-control">
			  		${file.fi_ori_name}
			  	</a>
			  </c:forEach>
			</div>
			<c:if test="${user.me_id == board.bd_me_id}">
				<a href="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}">
					<button class="btn btn-outline-warning">수정</button>
				</a>
				<a href="<%=request.getContextPath()%>/board/delete?bd_num=${board.bd_num}">
					<button class="btn btn-outline-danger">삭제</button>
				</a>
			</c:if>
			<!-- 현재 보고 있는 게시글이 원본 게시글 -->
			<c:if test="${board.bd_ori_num == board.bd_num && (board.bd_type == '일반')}">
				<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_num}">
					<button class="btn btn-outline-primary">답변</button>
				</a>
			</c:if>
			<!-- 현재 보고 있는 게시글이 답변 게시글  -->
			<c:if test="${board.bd_ori_num != board.bd_num && (board.bd_type == '일반')}">
				<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_ori_num}">
					<button class="btn btn-outline-primary">답변</button>
				</a>
			</c:if>
		</c:if>
		<c:if test="${board == null}">
			<h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
		</c:if>
		<div class="comment-list">
			
	  	</div>
	  	<div class="comment-pagination">
	  		<ul class="pagination justify-content-center">
			  <li class="page-item"><a class="page-link" href="javascript:void(0);">이전</a></li>
			  <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
			  <li class="page-item"><a class="page-link" href="javascript:void(0);">다음</a></li>
			</ul>
	  	</div>
		<div class="input-group mb-3 mt-3">
		  <textarea class="form-control text_content" placeholder="댓글입력"></textarea>
		  <div class="input-group-append">
		    <button class="btn btn-outline-success btn-comment-insert">등록</button>
		  </div>
		</div>
	</div>
	<script>
		commentService.setContextPath('<%=request.getContextPath()%>');
		$(function(){
			$('.btn-comment-insert').click(function() {
				var co_me_id = '${user.me_id}';
				if(co_me_id == ''){
					alert('로그인 후 댓글 등록이 가능합니다.');
					return;
				}
				var co_content = $('.text_content').val();
				var co_bd_num = '${board.bd_num}';
				if(co_content == ''){
					alert('댓글 내용을 입력하세요.')
					return;
				}
				var comment = {
						co_me_id : co_me_id,
						co_content : co_content,
						co_bd_num : co_bd_num
				};
				commentService.insert(comment, '/comment/insert', function(res) {
					if(res == true){
		        		$('.text_content').val('');
		        		alert('댓글 등록이 완료되었습니다.');
		        	}else{
		        		alert('댓글 등록에 실패했습니다.')
		        	};
				});
			});
			
			commentService.list('/comment/list?page=1&bd_num='+'${board.bd_num}', function(res){
				console.log(res);
			});
		});
		function createComment(comment, me_id) {
			var str = '';
			str += '<div class="comment-box clearfinx">'
			if(comment.co_ori_num != comment.co_num){
				str +=	 '<div class="float-left" style="width: 24px">└</div>'
				str +=	 '<div class="float-left" style="width: calc(100% - 24px)">'
			}else{
				str +=	 '<div class="float-left" style="width: 100%">'
			}
			str +=	  	'<div class="co_me_id">'+comment.co_me_id+'</div>'				
			str +=	 	'<div class="co_content">'+comment.co_content+'</div>'
			str +=	  	'<div class="co_reg_date">'+co_reg_date+'</div>'
			if(comment.co_ori_num == comment.co_num)
				str +=	  	'<button class="btn btn-outline-success btn-rep-comment">답글</button>'
			if(comment.co_me_id == me_id){
				str +=	  	'<button class="btn btn-outline-warning btn-mod-comment">수정</button>'
				str +=	  	'<button class="btn btn-outline-danger btn-del-comment">삭제</button>'
			}
			str +=   '</div>'
			str +=   '<hr class="float-left" style="width: 100%">'
			str += '</div>'
		}
	</script>
</body>
</html>