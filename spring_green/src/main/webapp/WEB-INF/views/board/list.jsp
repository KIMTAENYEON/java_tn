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
		<h1>${pm.criteria.typeTitle}</h1>
		<form class="input-group mb-3" action="<%=request.getContextPath()%>/board/list">
		  <input type="text" class="form-control" name="search" placeholder="검색어를 입력하세요." value="${pm.criteria.search}">
		  <div class="input-group-append">
		    <button class="btn btn-success" type="submit">검색</button>
		  </div>
		  <input type="hidden" name="type" value="${pm.criteria.type}">
		</form>
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
			    <c:if test="${board.bd_num == board.bd_ori_num}">
			    	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
			    </c:if>
			    <c:if test="${board.bd_num != board.bd_ori_num}">
			    	<td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">└답변:${board.bd_title}</a></td>
			    </c:if>
			    <td>${board.bd_me_id}</td>
			    <td>${board.bd_reg_date_str}</td>
			  </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<ul class="pagination justify-content-center">
		    <li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
		    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&search=${pm.criteria.search}&type=${pm.criteria.type}">이전</a>
		    </li>
		    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
			    <li class="page-item <c:if test="${pm.criteria.page == i}">active</c:if>">
			    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}&search=${pm.criteria.search}&type=${pm.criteria.type}">${i}</a>
			    </li>
		    </c:forEach>
		    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
		    	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&search=${pm.criteria.search}&type=${pm.criteria.type}">다음</a>
		    </li>
		</ul>
		<c:if test="${pm.criteria.type != '공지' || (user.me_authority == '관리자' || user.me_authority == '슈퍼 관리자')}">
		 	<a href="<%=request.getContextPath()%>/board/register?bd_type=${pm.criteria.type}">
				<button class="btn btn-outline-success">글쓰기</button>
			</a>
		</c:if>
	</div>
</body>
</html>