<%@page import="com.shbd.cors.util.ValidateUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.shbd.cors.dao.ICompanyDao"%>
<%@page import="com.shbd.cors.model.Company"%>
<%@page import="com.shbd.cors.model.CorsException"%>
<%@page import="com.shbd.cors.model.User"%>
<%@page import="com.shbd.cors.dao.IUserDao"%>
<%@page import="com.shbd.cors.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String nickname = request.getParameter("nickname");
	String  type = request.getParameter("type");
	String office = request.getParameter("office");
	String phone = request.getParameter("phone");
	boolean validate = ValidateUtil.validateNull(request, new String[]{"name","password","nickname"});	
	if(!validate){		
	//以下语句是服务器端跳转。
%>
	<jsp:forward page="addInput.jsp"></jsp:forward>
<%
	}
	
	User user = new User(name,password,nickname,office,phone);
	Company company = DaoFactory.getCompanyDao().load(1);
	user.setCompany(company);
	IUserDao userDao = DaoFactory.getUserDao();
	try{
		userDao.add(user);
		response.sendRedirect("list.jsp");
		return;

	}catch(CorsException e){
%>
<h2 style="color:red">发生错误:<%=e.getMessage()%></h2>

<%	
	}
%>
