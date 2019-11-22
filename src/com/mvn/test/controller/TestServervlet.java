package com.mvn.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class TestServervlet
 */
@WebServlet("/test")
public class TestServervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServervlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memSize = 1024*1024*5;
		int totalSize = 1024*1024*50;
		int fileSize = 1024*1024*10;
		DiskFileItemFactory dfif= new DiskFileItemFactory();
		dfif.setSizeThreshold(memSize);
		dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		sfu.setFileSizeMax(fileSize);
		sfu.setSizeMax(totalSize);
		if(ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> fList = sfu.parseRequest(request);
				for(FileItem fi : fList) {
					String key = fi.getFieldName();
					if(fi.isFormField()) {
						String value = fi.getString("utf-8");
						System.out.println(key+":"+value);
					}else {
						String path = "C:\\ict\\workspace\\mvn-test\\WebContent\\filetest";
						String fileName = fi.getName();
						File targetFile = new File(path+"\\"+fileName);
						fi.write(targetFile);
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			throw new ServletException("파일형식이 잘못되었습니다.");
		}
	}

}
