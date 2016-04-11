<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Json测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.3.js"></script>

<script type="text/javascript">
	var item={
			name:"Mogo",
			price:100,
			createtime:new Date(),
			detail:"this is mogo"
	};

	$(document).ready(function(){
		console.log("on ready ");
		console.log(JSON.stringify(item));
		
		$('#btnKey').click(requestKeyValue);
	});
		
	function requestJson(){
		var itemJson=JSON.stringify(item);
		console.log(itemJson);
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/requestJson.action',
			dataType:"json",      
            contentType:"application/json", 
			data:JSON.stringify(item),
			success:function(data){
				console.log(data);
				alert(data);
			},
			error:function(err){
				console.log(err);
				alert(err);				
			}
		});
	}
	
	function requestKeyValue(){
		$.ajax({
			type:'get',
			url:'${pageContext.request.contextPath}/requestKeyValue.action',
			data:'name=db&price=100f&detail=1234567890&createtime=2015-12-12 01:10:10',
			success:function(data){
				console.log(data);
				alert(data);
			},error:function(err){
				console.log(err);
				alert(err);
			}
		});
	}
</script>
</head>
<body>	
	<input type="button" value="请求Json输出Json" onclick="requestJson()"/>
	<input id="btnKey" type="button" value="请求key/value输出Json"/>
</body>
</html>