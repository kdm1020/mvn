package com.mvn.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="TargetServlet", urlPatterns= {"/target"} )
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/views/final";
		String[] as = request.getParameterValues("a");
		List<String> list = new ArrayList<>();
		for(String a:as) {
			list.add(a);
		}
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
