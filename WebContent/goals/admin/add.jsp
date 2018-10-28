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
</head>
<body>
<form action="<%=basePath%>/goal/add2" method="post">
        username:<input type="text" name="nickname"><br/>
        password:<input type="text" name="password"><br/>
        email:<input type="text" name="email"><br/><br/>
        username:<input type="text" name="nickname"><br/>
        password:<input type="text" name="password"><br/>
        email:<input type="text" name="email"><br/><br/>
        username:<input type="text" name="nickname"><br/>
        password:<input type="text" name="password"><br/>
        email:<input type="text" name="email"><br/><br/>
        <input type="submit" value="submit">
    </form>
    <form action="<%=basePath%>/goal/add3" method="post">
        username:<input type="text" name="users[0].nickname"><br/>
        password:<input type="text" name="users[0].password"><br/>
        email:<input type="text" name="users[0].email"><br/><br/>
        username:<input type="text" name="users[1].nickname"><br/>
        password:<input type="text" name="users[1].password"><br/>
        email:<input type="text" name="users[1].email"><br/><br/>
        username:<input type="text" name="users[2].nickname"><br/>
        password:<input type="text" name="users[2].password"><br/>
        email:<input type="text" name="users[2].email"><br/><br/>
        <input type="submit" value="add3">
    </form>
</body>
</html>