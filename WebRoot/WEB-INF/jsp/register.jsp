<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/registerSubmit.action">
		<p>用户名：<input type="text" name="username" /></p>
		<p>密　码：<input type="password" name="password" /></p>
		<p>生　日：<input type="text" name="birthday"/></p>
		<p>性　别：<input type="radio" value="1" name="sex" checked="checked"/>男
		<input type="radio" value="0" name="sex"/>女</p>
		<p>家庭住址：<input type="text" name="address"/></p>
		<p><input type="submit" value="注册"/></p>
	</form>
</body>
</html>