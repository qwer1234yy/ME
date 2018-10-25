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
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-3.3.1.min.js"> </script>
<script type="text/javascript">
$(document).ready(function(){
	$("#allGoal").click(function(){
		$.ajax({
			url:"/goal/all",
			type:"post",
			dataType:"json",
			contentType:"application/json",
			data:"NO",
			success:function(data){
				var users=eval(data.data);
				alert(users.length);
				alert(data.msg+JSON.stringify(data.data));
				alert(users[0].email);
				for ( var i=0; i< users.length;i++) {
					alert(users[i].email);
				}
			}
		});
	});
	
});
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
<button id="allGoal" type="button">Show all Goals</button>
<form action="getall" method="post">
<button id="getall" type="submit">getall</button>
</form>
</body>
</html>