<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<% String path = request.getContextPath();
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
test
${path }${basePath }
<%=basePath %>
<form:form method="POST" action="${basePath }adduser">
   <table>
    <tr>
        <td><form:label path="nickname">昵稱：</form:label></td>
        <td><form:input path="nickname" /></td>
    </tr>
    <tr>
        <td><form:label path="password">密碼：</form:label></td>
        <td><form:input path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="email">郵箱：</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="提交"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>