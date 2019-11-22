package com.mvn.test.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.session.SqlSession;

import com.mvn.test.common.ServletFileUtil;
import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.pbDAO;
import com.mvn.test.dao.Impl.pbDAOImpl;
import com.mvn.test.service.pbService;
import com.mvn.test.vo.PbVO;

public class pbServiceImpl implements pbService {
	private pbDAO pbdao = new pbDAOImpl();
	private String path = "C:\\ict\\workspace\\mvn-test\\WebContent\\img\\";
	private PbVO pb = new PbVO();
	
	public Map<String, String> insertPb(Map<String, Object> param) {
		SqlSession ss = InitServlet.getSqlSession();
		pb.setPbTitle((String) param.get("pbTitle"));
		pb.setPbContent((String) param.get("pbContent"));
		pb.setCreusr(Integer.parseInt((String) param.get("creusr")));
		Map<String, String> rMap = new HashMap<>();
		rMap.put("msg", "실패");
		rMap.put("result", "false");
		try {
			
			if (param.get("pbImg1") != null) {
				FileItem fi = (FileItem) param.get("pbImg1");
				String fileName = ServletFileUtil.saveFile(fi);
				pb.setPbImg1("/img/"+fileName);
			}
			if (param.get("pbImg2") != null) {
				FileItem fi = (FileItem) param.get("pbImg2");
				String fileName = ServletFileUtil.saveFile(fi);
				pb.setPbImg2("/img/"+fileName);
			}
			int cnt = pbdao.insertpb(ss, pb);
			if (cnt == 1) {
				rMap.put("msg", "성공");
				rMap.put("result", "true");
			}
			System.out.println("2단계:"+pb);// 서비스에서 테스트(2단계)
			ss.commit();
		} catch (Exception e) {
			ss.rollback();
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return rMap;
	}

	@Override
	public List<PbVO> selectPb() {
		SqlSession ss = InitServlet.getSqlSession();
		try {
		return pbdao.selectpb(ss);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}

}
