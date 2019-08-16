<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>글 목록</h1>
	
	<table border="1">
		<col width="50">
		<col width="100">
		<col width="300">
		<col width="100">
		
		<tr>
			<th>번  호</th>
			<th>작성자</th>
			<th>제  목</th>
			<th>작성일</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4" align="center">-----------작성된 글이 존재하지 않습니다.-----------</td>
				</tr>
			</c:when>
			<c:otherwise> <%-- list가 null이 아닌 무언가 있을 경우 --%>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.seq } </td>
						<td>${dto.writer } </td>
						<td><a href="controller.do?command=selectOne&seq=${dto.seq }">${dto.title } </a></td>
						<td>${dto.regdate } </td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		<tr>
			<td colspan="4">
				<input type="button" value="글쓰기" onclick="location.href='controller.do?command=insert'">
			</td>
		</tr>
	</table>
</body>
</html>