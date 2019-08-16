<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<style type="text/css">
body {
	text-align: center;
}

#paging {
	font-size: 15pt;
}
</style>
</head>
<body>
	<div id="paging">
		<!-- 1~10까지 있는 페이지의 페이징 -->
		<c:url var="action" value="paging.do?command=pagingpagelist" />
		<c:if test= "${param.prev }" >
			<a href="${action}&page=${param.beginPage-1}">prev</a>
		</c:if>
		<c:forEach begin="${param.beginPage}" end="${param.endPage}" step="1" var="index">
			<c:choose>
				<c:when test="${param.page==index}">${index}
        			</c:when>
				<c:otherwise>
					<a href="${action}&page=${index}">${index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${param.next}">
			<a href="${action}&page=${param.endPage+1}">next</a>
		</c:if>
	</div>
</body>
</html>
