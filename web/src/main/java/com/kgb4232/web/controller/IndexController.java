package com.kgb4232.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgb4232.web.service.IndexService;
import com.kgb4232.web.util.Util;

@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@Autowired
	private Util util;
	
	@GetMapping({"/index", "/"})
	public String index(Model model) {
		//메뉴 불러오기
				List<Map<String, String>> menu = indexService.menu();
				model.addAttribute("menu", menu);
		return "index";
	}
			
	@GetMapping("/freeboard")
	public String freeboard(@RequestParam(value="cate", defaultValue="1") int cate, Model model) {
		//메뉴 불러오기
		List<Map<String, String>> menu = indexService.menu();
		model.addAttribute("menu", menu);
		List<Map<String, Object>> fb = indexService.freeboard(cate);
		model.addAttribute("fb", fb);
		model.addAttribute("cate", cate);
		//카테 네임 불러서 한 파일에 여러개를 돌아가면서 사용함
		return "freeboard";
	}
			
	// 상세보기 -> no 잡기 -> 확인
	// detail.html
	// 값 -> DB에 물어보기 어떤 형태로?
	@GetMapping("/detail")
	public String detail(@RequestParam("no") int no, Model model) {
		//메뉴 불러오기
				List<Map<String, String>> menu = indexService.menu();
				model.addAttribute("menu", menu);
		Map<String, Object> detail = indexService.detail(no);
		model.addAttribute("detail", detail);
		return "detail";
	}
	
	@GetMapping("/notice")
	public String notice(@RequestParam(value="cate", defaultValue="2") int cate, Model model) {
		//메뉴 불러오기
				List<Map<String, String>> menu = indexService.menu();
				model.addAttribute("menu", menu);
		List<Map<String, Object>> fb = indexService.freeboard(cate);
		model.addAttribute("fb", fb);
		return "notice";
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		// 메뉴 불러오기
		List<Map<String, String>> menu = indexService.menu();
		model.addAttribute("menu", menu);
		// 로그인 검사
		return "write";
	}
	
	@PostMapping("/write")
	public String write(@RequestParam Map<String, Object> map) {
		// 로그인 검사해주세요. 20240311 psd
		// System.out.println(map); 172.30.1.75
		int result = indexService.write(map);
		// System.out.println(result);
		String url = "freeboard";
		return "redirect:/" + url;
	}
	
	@PostMapping("/postDel")
	public String postDel(@RequestParam("no") int no) {
		//System.out.println(no);
		//로그인 검사 추가 24-03-11
		if (util.getSession().getAttribute("mid") != null) {
			int result = indexService.postDel(no);
			return "redirect:/freeboard";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/postUpdate")
	public String postUpdate(@RequestParam("no") int no, Model model) {
		if (util.getSession().getAttribute("mid") != null) {
			// 메뉴 불러오기
			List<Map<String, String>> menu = indexService.menu();
			model.addAttribute("menu", menu);

			Map<String, Object> update2 = indexService.detail(no);
			model.addAttribute("update", update2);
			return "update";
		} else {
			return "redirect:/login";
		}
	}
	
	@PostMapping("/postUpdate")
	public String postUpdate(@RequestParam() Map<String, Object> map) {

		indexService.postUpdate(map);
		return "redirect:/detail?no=" + map.get("mtno");
	}
	
}
