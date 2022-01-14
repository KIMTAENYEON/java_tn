<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="body">
		<form action="<%=request.getContextPath()%>/board/modify" method="post">
			<c:if test="${board != null}">
				<h1>게시글 수정</h1>
				<div class="form-group">
				  <label>제목</label>
				  <input type="text" class="form-control" name="bd_title" value="${board.bd_title}">
				</div>
				<div class="form-group">
				  <label>내용</label>
				  <textarea class="form-control" rows="10" name="bd_content">${board.bd_content}</textarea>
				</div>
				<input type="hidden" name="bd_num" value="${board.bd_num}">
				<c:if test="${user != null && user.me_id == board.bd_me_id}">
					<button class="btn btn-outline-warning">수정</button>
				</c:if>
			</c:if>
		</form>
	</div>
</body>
</html>