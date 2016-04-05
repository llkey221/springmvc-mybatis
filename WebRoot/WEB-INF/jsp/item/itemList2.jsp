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
	查询条件：
	<form action="${pageContext.request.contextPath }/queryItems2.action" method="post">
		<table width="100%" border="1">
			<tr>
				<td><input type="text" name="itemsCustom.name"/></td>
				<td><input type="submit" value="查询"/></td>
			</tr>
		</table>
	</form>
	
	<form action="${pageContext.request.contextPath }/editAllItems.action" method="post">
	<table width="100%" border="1">
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>生产日期</td>
			<td>商品描述</td>
			<td>操作</td>
		</tr>
			<c:forEach items="${itemsCustomList }" var="item" varStatus="status" >
				<tr>
					<input type="hidden" name="ids" value="${item.id }"/>
					<input type="hidden" name="itemsCustoms[${status.index}].id"  value="${item.id}"/>
					<td><input type="text"  name="itemsCustoms[${status.index}].name" value="${item.name }"/></td>
					<td><input type="text" name="itemsCustoms[${status.index}].price" value="${item.price }"/></td>
					<td><input type="text"  name="itemsCustoms[${status.index}].createtime"   value='<fmt:formatDate value="${item.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/>'/></td>
					<td><input type="text" name="itemsCustoms[${status.index}].detail"  value="${item.detail }"/></td>
					<td><a href="${pageContext.request.contextPath }/editItem.action?id=${item.id}">修改</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5">
					<input type="submit" value="批量修改"/>
					</td>
			</tr>
	</table>
</form>
</body>
</html>