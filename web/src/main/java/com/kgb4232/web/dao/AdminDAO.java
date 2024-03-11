package com.kgb4232.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminDAO {

	List<Map<String, Object>> menu();

	void menuInsert(Map<String, Object> map);
}
