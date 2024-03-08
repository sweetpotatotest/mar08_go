package com.kgb4232.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgb4232.web.dto.BoardDTO;
import com.kgb4232.web.service.IndexService;

@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@GetMapping({"/index", "/"})
	public String index(Model model) {
		return "index";
	}
			
	@GetMapping("/freeboard")
	public String freeboard(@RequestParam(value="cate", defaultValue="1") int cate, Model model) {
		List<BoardDTO> fb = indexService.freeboard(cate);
		model.addAttribute("fb", fb);
		return "freeboard";
	}
			
	// 상세보기 -> no 잡기 -> 확인
	// detail.html
	// 값 -> DB에 물어보기 어떤 형태로?
	@GetMapping("/detail")
	public String detail(@RequestParam("no") int no, Model model) {
		BoardDTO detail = indexService.detail(no);
		model.addAttribute("detail", detail);
		return "detail";
	}
	
	@GetMapping("/notice")
	public String notice(@RequestParam(value="cate", defaultValue="2") int cate, Model model) {
		List<BoardDTO> fb = indexService.freeboard(cate);
		model.addAttribute("fb", fb);
		return "notice";
	}
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(@RequestParam Map<String, Object> map) {
		int result = indexService.write(map);
		return "write";
	}
	
	@PostMapping("/postDel")
	public String postDel(@RequestParam("no") int no) {
		//System.out.println(no);
		int result = indexService.postDel(no);
		return "redirect:/freeboard";
	}
	
}
