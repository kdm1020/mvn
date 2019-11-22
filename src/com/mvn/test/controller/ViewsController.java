package com.mvn.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ViewsController", urlPatterns= {"/views/*"}, loadOnStartup = 2)
public class ViewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX="/WEB-INF";
	private static final String SUFFIX=".jsp";
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = PREFIX + request.getRequestURI()+ SUFFIX;
		response.setContentType("application/json;charset=utf-8");

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
