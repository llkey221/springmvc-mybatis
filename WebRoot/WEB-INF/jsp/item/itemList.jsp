<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息列表</title>
</head>
<body>
<p>${username }， 		
	<c:if test="${username!=null }">
		<a href="${pageContext.request.contextPath }/logout.action">退出</a>
	</c:if>
</p>
	查询条件：
	<form action="${pageContext.request.contextPath }/queryItems.action" method="post">
	<table width="100%" border="1">
		<tr>
			<td><input type="text" name="itemsCustom.name"/></td>
			<td>
				<select name="itemType">
					<c:forEach items="${itemTypes}" var="type">
						<option value="${type.key }">${type.value}</option>
					</c:forEach>
				</select>
			</td>
			<td><input type="submit" value="查询"/></td>
		</tr>
	</table>
	<table width="100%" border="1">
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>生产日期</td>
			<td>商品描述</td>
			<td>操作</td>
		</tr>
			<c:forEach items="${itemsCustoms }" var="item">
				<tr>
					<td>${item.name }</td>
					<td>${item.price }</td>
					<td><fmt:formatDate value="${item.createtime }" pattern="yyyy-MM-dd"/></td>
					<td>${item.detail }</td>
					<td><a href="${pageContext.request.contextPath }/editItem.action?id=${item.id}">修改</a></td>
				</tr>
			</c:forEach>
	</table>
	</form>
</body>
</html>