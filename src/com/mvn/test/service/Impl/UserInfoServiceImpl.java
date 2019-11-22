package com.mvn.test.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.dao.Impl.UserInfoDAOImpl;
import com.mvn.test.service.UserInfoService;
import com.mvn.test.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uidao = new UserInfoDAOImpl();
	
	@Override
	public List<UserInfoVO> getUserList(Map<String, String> user) {
		return uidao.selectUserList(user);
	}

	@Override
	public UserInfoVO selectUser(UserInfoVO user) {
		return uidao.selectUser(user);
	}

	@Override
	public Map<String, String> insertUser(UserInfoVO user) {
		Map<String, String> rMap = new HashMap<>();
		rMap.put("msg", "회원가입 실패.");
		rMap.put("result", "false");
		int result = uidao.insertUser(user);
		if(result==1) {
			rMap.put("msg", "회원가입 완료.");
			rMap.put("result", "true");
		}
		return rMap;
	}

	@Override
	public Map<String, String> updateUser(UserInfoVO user) {
		Map<String, String> rMap = new HashMap<>();
		rMap.put("msg", "정보수정실패.");
		rMap.put("result", "false");
		int result = uidao.updateUser(user);
		if(result==1) {
			rMap.put("msg", "정보수정실패 완료.");
			rMap.put("result", "true");
		}
		return rMap;
	}

	@Override
	public Map<String, String> deleteUser(UserInfoVO user) {
		Map<String, String> rMap = new HashMap<>();
		rMap.put("msg", "회원삭제 실패.");
		rMap.put("result", "false");
		int result = uidao.deleteUser(user);
		if(result==1) {
			rMap.put("msg", "회원삭제 완료.");
			rMap.put("result", "true");
		}
		return rMap;
	}

}
