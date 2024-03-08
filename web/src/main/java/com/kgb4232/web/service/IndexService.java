package com.kgb4232.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgb4232.web.dao.IndexDAO;
import com.kgb4232.web.dto.BoardDTO;
import com.kgb4232.web.util.Util;

@Service
public class IndexService {

	@Autowired
	private IndexDAO indexDAO;
	
	@Autowired
	private Util util;
	
	public List<Map<String, Object>> boardList() {
		return indexDAO.boardList();
	}

	public BoardDTO detail(int no) {
		return indexDAO.detail(no);
	}

	public List<BoardDTO> freeboard(int cate) {
		return indexDAO.freeboard(cate);
	}

	public int write(Map<String, Object> map) {
		// db - mid, ip 추가
		map.put("mid", "test1");
		map.put("mtip", util.getIP());
		return indexDAO.write(map);
	}

	public int postDel(int no) {
		return indexDAO.postDel(no);
	}

}
