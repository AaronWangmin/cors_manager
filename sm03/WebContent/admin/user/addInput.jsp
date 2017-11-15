<%@page import="com.shbd.cors.util.ValidateUtil"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="inc.jsp">
	<jsp:param value="ADD" name="op"/>
</jsp:include>

<form action="add.jsp" method="post">
<table align="center" width="500" border=""1>
	<tr>
		<td>用户名称：</td>
		<td><input type="text" name="name" value="<%=request.getParameter("name")%>"/><%=ValidateUtil.showError(request, "name") %></td>
	</tr>
	<tr>
		<td>用户密码：</td>
		<td><input type="password" name="password" /><%=ValidateUtil.showError(request, "password") %></td>
	</tr>
	<tr>
		<td>用户呢称：</td>
		<td><input type="text" name="nickname" value="<%=request.getParameter("nickname")%>"/><%=ValidateUtil.showError(request, "nickname") %></td>
	</tr>
	<tr>
		<td>用户类型：</td><td><input type=="text" name="type" /></td>
	</tr>
	<tr>
		<td>公司职务：</td><td><input type="text" name="office" /></td>
	</tr>
	<tr>
		<td>联系电话：</td><td><input type="text" name="phone" /></td>
	</tr>
	<tr>
		<td>公司名称：</td><td><input type="text" name="company" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="添加用户" />
		</td>
	</tr>

</table>


</form>

</body>
</html>