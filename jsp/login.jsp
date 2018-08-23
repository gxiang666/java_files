<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginCl.jsp" method="post">
		用户名：<input type="text" name="name"/>
		<%-- <%
			String msg = (String) request.getAttribute("msg");
			out.println(msg);
		%> --%>
		
		<%--判断请求的属性是否为空 --%>
		<%=request.getAttribute("msg")!=null?request.getAttribute("msg"):"" %>
		<br>
	密码：<input type="password" name="pwd"/><br>
	<input type="submit" value="提交"/>
	</form>
</body>
</html>