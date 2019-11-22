package com.mvn.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.PbVO;

public interface pbDAO {
	public int insertpb(SqlSession ss, PbVO pb);
	List<PbVO>selectpb(SqlSession ss);
}
