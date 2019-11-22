package com.mvn.test.service;

import java.util.List;
import java.util.Map;

import com.mvn.test.vo.UserInfoVO;

public interface FileTestService {
	public Map<String,String> insertFileTest(Map<String,Object> param);
	public List<Map<String,String>> selectFileTest();

}
