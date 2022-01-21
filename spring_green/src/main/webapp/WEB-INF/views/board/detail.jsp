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
	</div>
</body>
</html>