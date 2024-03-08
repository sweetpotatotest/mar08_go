package com.kgb4232.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgb4232.web.service.MemberService;
import com.kgb4232.web.util.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private Util util;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login2(@RequestParam Map<String, Object> map) {
		Map<String, Object> check = memberService.login(map);
		//System.out.println(check);
		//자바 17에 추가된 기능
		String txt = """
				텍스트
				텍스트
				텍스트
				"""; // 텍스트 블럭
		
		if (util.str2Int(check.get("count")) == 1) {
			HttpSession session = util.getSession();
			session.setAttribute("mid", map.get("id"));
			session.setAttribute("mname", check.get("mname"));
			return "redirect:/freeboard";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("mname") != null) {
			session.removeAttribute("mname");
		}
		if (session.getAttribute("mid") != null) {
			session.removeAttribute("mid");
		}
		session.invalidate();
		return "redirect:/login";
	}
	
}
