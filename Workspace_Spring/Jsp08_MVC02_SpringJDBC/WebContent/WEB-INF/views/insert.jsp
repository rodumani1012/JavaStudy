<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>글 작성</h1>
	
   <form action="insert_res.spr" method="post">
      <table border="1">
         <tr>
            <th>작성자</th>
            <td><input type="text" name="writer"></td>
         </tr>
         <tr>
            <th>제  목</th>
            <td><input type="text" name="title"></td>
         </tr>
         <tr>
            <th>내  용</th>
            <td><textarea rows="20" cols="60" name="content"></textarea></td>
         </tr>
         <tr>
            <td colspan="2">
               <input type="submit" value="작성">
               <input type="reset" value="리셋">
               <input type="button" value="뒤로 가기" onclick="location.href='list.spr'">
            </td>
         </tr>
      </table>
   </form>

</body>
</html>