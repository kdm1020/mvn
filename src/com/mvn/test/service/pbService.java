package com.mvn.test.service;

import java.util.List;
import java.util.Map;

import com.mvn.test.vo.PbVO;

public interface pbService {
	public Map<String,String> insertPb(Map<String,Object> param);
	List<PbVO>selectPb();
}
