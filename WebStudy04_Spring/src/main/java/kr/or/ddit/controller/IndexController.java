package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index.do")
public class IndexController {
	@GetMapping
	protected String doGet() {
	
		return "index"; 
		
	}
}