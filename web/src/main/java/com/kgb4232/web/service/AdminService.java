package com.kgb4232.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgb4232.web.dao.AdminDAO;

@Service
public class AdminService {

	@Autowired 
	private AdminDAO adminDAO;
	
	public List<Map<String, Object>> menu(){
		return adminDAO.menu();
	}

	public void menuInsert(Map<String, Object> map) {
		adminDAO.menuInsert(map);
	}

	
}
