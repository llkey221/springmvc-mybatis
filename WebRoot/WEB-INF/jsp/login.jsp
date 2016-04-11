<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/loginSubmit.action" method="post">
		<p>用户名：<input type="text" name="username" /></p>
		<p>密　码：<input type="password" name="password" /></p>
		<p><input type="submit" value="提 交"/></p>
		<p><a href="${pageContext.request.contextPath }/register.actoin">免费注册</a></p>
	</form>
</body>
</html>