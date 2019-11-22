package com.mvn.test.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.dao.pbDAO;
import com.mvn.test.vo.PbVO;

public class pbDAOImpl implements pbDAO {

	@Override
	public int insertpb(SqlSession ss, PbVO pb) {
		return ss.insert("pb.insertpb",pb);
	}

	@Override
	public List<PbVO> selectpb(SqlSession ss) {
		return ss.selectList("pb.selectpb");
	}

}
