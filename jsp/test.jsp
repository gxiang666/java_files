<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 这个是HTML的注释标签 -->
	
	<%--这个是jsp的注释标签 --%>


	<%
		//这个是jsp的脚本标签，会出现在service方法里
		//标签里不能出现方法 
		String name = "熊高祥";
		int age = 23;
	%>
	
	<%!
		//这是一个声明标签，最终会出出现在类下，可以定义方法
		String getStudentNmae(){
			return "熊高祥";
		}
	%>
	
	<%=
		//这是一个赋值标签，可以进行赋值和输出
		//会出现在print()里，标签最后不能出现分号
		getStudentNmae()
	%>
	
</body>
</html>