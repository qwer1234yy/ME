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
</head>
<body>
<form action="user/register">
nickname:<input type="text" name="nickname"/>
password:<input type="text" name="password"/>
email:<input type="text" name="email"/>
<input type="submit" value="submit"/>
</form>
</body>
</html>