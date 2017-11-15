<%@page import="com.shbd.cors.model.CorsException"%>
<%@page import="com.shbd.cors.model.User"%>
<%@page import="com.shbd.cors.dao.DaoFactory"%>
<%@page import="com.shbd.cors.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	try{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		IUserDao ud = DaoFactory.getUserDao();
		User u = ud.login(name, password);
		session.setAttribute("loginUser", u);
		response.sendRedirect(request.getContextPath() + "/admin/user/list.jsp");
		
	}catch(CorsException e){
%>
	<h2 style="color:red">发生错误：<%=e.getMessage() %></h2>
<%
	}
	
	
%>

</body>
</html>