<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String[] a={};
RequestDispatcher rd = request.getRequestDispatcher("/target.jsp");
rd.forward(request,response);
%>
