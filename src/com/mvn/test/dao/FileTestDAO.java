package com.mvn.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface FileTestDAO {
	public int insertFileTest(SqlSession ss,Map<String,String> fileTest);
	public List<Map<String,String>> selectFileTestList(SqlSession ss);
}
