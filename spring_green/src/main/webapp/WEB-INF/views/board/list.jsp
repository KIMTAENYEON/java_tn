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
	</div>
</body>
</html>