<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//假如你的项目名称是ssp,那么basePath最后获得的值就是 --> http://localhost:8080/ssp/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
		$("#allGoal").click(function() {
			$.ajax({
				url : "/goal/all",
				type : "post",
				dataType : "json",
				contentType : "application/json",
				data : "NO",
				success : function(data) {
					var users = eval(data.data);
					alert(users.length);
					alert(data.msg + JSON.stringify(data.data));
					alert(users[0].email);
					for (var i = 0; i < users.length; i++) {
						alert(users[i].email);
					}
				}
			});
		});
	});
	function submitUserList_3() {
		alert("ok");
		var customerArray = new Array();
		customerArray.push({
			nickname : "1sdf",
			password : "李四",
			email : "123@qq.com"
		});
		customerArray.push({
			nickname : "2df",
			password : "李四2",
			email : "123@qq.com"
		});
		$.ajax({
			url : "<%=basePath%>/goal/add4",
			type : "POST",
			contentType : 'application/json;charset=utf-8', //设置请求头信息
			dataType : "json",
			data: JSON.stringify(customerArray),    //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
			//data : $.toJSON(customerArray), //将Json对象序列化成Json字符串，toJSON()需要引用jquery.json.min.js
			success : function(data) {
				alert(data);
			},
			error : function(res) {
				alert(res.responseText);
			}
		});
	}
</script>
</head>
<body>
	index${message}${user}
	<a href="all">display all goals</a>
	<a href="toadduser">add a user</a>
	<a href="admin_get">get a user</a>
	<a href="tologin">login</a>
	<a href="toregi">register</a>
	<%=basePath%>------<%=path%>
	<a href="goal/remove">remove goal</a>
	<a href="goal/toAdd">Add</a>
	<input id="submit" type="button" value="Add4Json" onclick="submitUserList_3()">
	<button id="allGoal" type="button">Show all Goals</button>
	<form action="getall" method="post">
		<button id="getall" type="submit">getall</button>
	</form>
	delivery parameters
	${requestScope.username}-Map${requestScope.email}-${list.aGoal.descript }-session${sessionScope.sessionname1 }${sessionScope.sessionname2 }-
	-requestP${requestScope.requestP1 }${requestScope.requestP2 }
</body>
</html>