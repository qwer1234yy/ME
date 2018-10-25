<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
    String path = request.getContextPath();
         //假如你的项目名称是ssp,那么basePath最后获得的值就是 --> http://localhost:8080/ssp/
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="ctl00" method="post" action="<%=basePath %>user/regi" id="f">
		<table>
			<tr>
				<td>email</td>
				<td><input name="email" /></td>
			</tr>
			<tr>
				<td>nickname</td>
				<td><input name="nickname" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="password" /></td>
			</tr>
		</table>

	</form>
</body>
</html>