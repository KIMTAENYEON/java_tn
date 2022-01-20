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
		<h1>게시글</h1>
		<table class="table table-dark table-hover">
		  <thead>
		    <tr>
		      <th>번호</th>
		      <th>제목</th>
		      <th>작성자</th>
		      <th>작성일</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach var="board" items="${list}">
			  <tr>
			    <td>${board.bd_num}</td>
			    <td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
			    <td>${board.bd_me_id}</td>
			    <td>${board.bd_reg_date_str}</td>
			  </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<ul class="pagination justify-content-center">
		    <li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
		    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}">이전</a>
		    </li>
		    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
			    <li class="page-item <c:if test="${pm.criteria.page == i}">active</c:if>">
			    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}">${i}</a>
			    </li>
		    </c:forEach>
		    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
		    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}">다음</a>
		    </li>
		  </ul>
		<a href="<%=request.getContextPath()%>/board/register">
			<button class="btn btn-outline-success">글쓰기</button>
		</a>
	</div>
</body>
</html>