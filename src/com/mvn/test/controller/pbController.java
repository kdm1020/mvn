package com.mvn.test.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mvn.test.common.ServletFileUtil;
import com.mvn.test.service.pbService;
import com.mvn.test.service.Impl.pbServiceImpl;
import com.mvn.test.vo.PbVO;

@WebServlet("/pb/*")
public class pbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private pbService pbs = new pbServiceImpl();
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String cmd = request.getParameter("cmd");
		if("view".equals(cmd)) {
			
		}else if(cmd==null) {
		String json = gson.toJson(pbs.selectPb());
		response.getWriter().print(json);
		System.out.println("테스트"+json);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		String Json ="";		
		Map<String, Object> param = ServletFileUtil.parseRequest(request);
		JsonElement
		PbVO pb = gson.fromJson(je, PbVO.class);
		System.out.println("1단계:"+param);//컨트롤러까지 완성한 후 테스트.(1단계)
		Map<String, String> rMap = pbs.insertPb(param);
		System.out.println("3단계:"+rMap);//서비스까지 완성후 테스트 (3단계)

		
	}

}
