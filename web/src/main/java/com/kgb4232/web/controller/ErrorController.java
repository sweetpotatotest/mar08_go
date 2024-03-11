package com.kgb4232.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

	@GetMapping("/error")
	public String error(HttpServletRequest request, Model model) {
		return "error";
	}
}
