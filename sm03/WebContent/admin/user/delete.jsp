<%@page import="com.shbd.cors.dao.DaoFactory"%>
<%@page import="com.shbd.cors.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	int id = Integer.parseInt(request.getParameter("id"));
	IUserDao userDao = DaoFactory.getUserDao();
	userDao.delete(id);
	response.sendRedirect("list.jsp");
%>