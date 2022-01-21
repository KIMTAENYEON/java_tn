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
		<h1>${board.typeTitle}</h1>
		<form action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">
			<div class="form-group">
			  <label>제목</label>
			  <input type="text" class="form-control" name="bd_title" placeholder="제목">
			</div>
			<div class="form-group">
			  <label>내용</label>
			  <textarea class="form-control" name="bd_content" placeholder="내용" rows="10"></textarea>
			</div>
			<div class="form-group">
			  <label>첨부파일</label>
			  <input type="file" class="form-control" name="files2">
			  <input type="file" class="form-control" name="files2">
			  <input type="file" class="form-control" name="files2">
			</div>
			<c:if test="${board.bd_ori_num != null}">
				<input type="hidden" name="bd_ori_num" value="${board.bd_ori_num}">
			</c:if>
			<input type="hidden" name="bd_type" value="${board.bd_type}">
			<button class="btn btn-outline-success col-12">등록</button>
		</form>
	</div>
</body>
</html>