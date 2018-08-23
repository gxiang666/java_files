<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		out.println("登录名：" + name);
		String pwd = request.getParameter("pwd");
		if("siggy".equals(name) && "1111".equals(pwd)){
			//登陆成功
			session.setAttribute("username", name);
			//重定向
			response.sendRedirect("hello.jsp");
		} else{
			//登录失败   请求转发
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	%>
</body>
</html>