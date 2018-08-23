<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if("${msg}" != ""){
		slert("${msg}")
	}
</script>
</head>
<body>

	<form action="login" method="post">
		用户名：<input type="text" name="name"/><br>
		密码：<input type="password" name="pwd"/><br>
	<input type="submit" value="提交"/>
	</form>
</body>
</html>