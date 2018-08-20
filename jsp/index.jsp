<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 这个是声明标签：声明的内容出现在Class下，属于成员变量和方法 -->
	<%!
		int a= 10;
		public int sum(int a, int b){
			return a+b;
		}
	%>
	
	<!-- 这个是赋值标签：最终会出现在java文件的print括号里，并且可以调用声明标签  -->
	<!-- 结果会显示在屏幕上 ，注意语句后面不能有分号 -->
	<%= sum(1,2) %> <br>
	
	<!-- 这是一个脚本标签，会出现在service中，局部变量，不能写入方法 -->
	<% int a=10; %>
	
	<!-- 写在标签里的不会被当做字符串 -->	
	<%
		for (int i=0; i<10; i++){
	%>
		<!-- 没有被标签包围的默认会被当做字符串输出到屏幕上 -->
		<a href="图片<%=  i+1 %>">图片<%= i+1 %>.jpg</a><br/>
		<% } %>
		
		<%= "xionggaoxiang" %>
</body>
</html>