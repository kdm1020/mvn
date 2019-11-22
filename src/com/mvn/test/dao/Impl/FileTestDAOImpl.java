package com.mvn.test.dao.Impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.FileTestDAO;

public class FileTestDAOImpl implements FileTestDAO {

	@Override
	public int insertFileTest(SqlSession ss,Map<String, String> fileTest) {
		return ss.insert("FileTest.insertFileTest",fileTest);
	}

	@Override
	public List<Map<String, String>> selectFileTestList(SqlSession ss) {
		return ss.selectList("FileTest.selectFileTest");
	}
}
