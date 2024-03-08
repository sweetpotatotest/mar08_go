package com.kgb4232.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kgb4232.web.dto.BoardDTO;

@Repository
@Mapper
public interface IndexDAO {

	List<Map<String, Object>> boardList();

	BoardDTO detail(int no);

	List<BoardDTO> freeboard(int cate);

	int write(Map<String, Object> map);

	int postDel(int no);

}
