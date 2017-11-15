<%@page import="com.shbd.cors.dao.DaoFactory"%>
<%@page import="com.shbd.cors.dao.IUserDao"%>
<%@page import="com.shbd.cors.model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	IUserDao userDao = DaoFactory.getUserDao();
	List<User> users = userDao.list();
%>
</head>
<body>
<jsp:include page="inc.jsp">
	<jsp:param value="LIST" name="op"/>
</jsp:include>

<table align="center" width="800" border="1">
	<tr>
		<td>用户id</td><td>用户名称</td><td>用户密码</td><td>用户呢称</td><td>操作</td>
	</tr>
	<%
		for(User u:users){
	%>
	<tr>
		<td><%=u.getId()%></td>
		<td><%=u.getName()%></td>
		<td><%=u.getPassword()%></td>
		<td><%=u.getNickname()%></td>
		<td><a href="delete.jsp?id=<%=u.getId()%>">删除</a>&nbsp;
			<a href="updateInput.jsp?id=<%=u.getId()%>">更新</a>
		</td>
	</tr>	
	<%
		}
	
	%>

</table>




</body>
</html>