package com.mvn.test.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.mvn.test.service.FileTestService;
import com.mvn.test.service.Impl.FileTestServiceImpl;

@WebServlet("/file")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileTestService fts = new FileTestServiceImpl();
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String json = gson.toJson(fts.selectFileTest());
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int memSize = 1024 * 1024 * 5;// 5MB
		int totalSize = 1024 * 1024 * 50;// 50MB
		int fileSize = 1024 * 1024 * 10;// 10MB
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		dfif.setSizeThreshold(memSize);
		dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		sfu.setFileSizeMax(fileSize);
		sfu.setSizeMax(totalSize);
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> fList = sfu.parseRequest(request);
				Map<String,Object> param = new HashMap<>();
				for (FileItem fi : fList) {
					String key = fi.getFieldName();
					if (fi.isFormField()) {
						String value = fi.getString("utf-8");
						param.put(key,value);
//						System.out.println(key + ":" + value);
					} else {
//						String path = "C:\\ict\\workspace\\mvn-test\\WebContent\\img";
//						String fileName = fi.getName();
//						File targetFile = new File(path+"\\"+fileName);
//						fi.write(targetFile);
						param.put(key,fi);
					}
//				System.out.println(fi.getFieldName());
				}
				fts.insertFileTest(param);
				System.out.println(param);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new ServletException("파일형식이 잘못되었습니다.");
		}
	}

}
