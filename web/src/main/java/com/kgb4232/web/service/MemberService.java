package com.kgb4232.web.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgb4232.web.dao.MemberDAO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public Map<String, Object> login(Map<String, Object> map) {
		return memberDAO.login(map);
	}

	
}
