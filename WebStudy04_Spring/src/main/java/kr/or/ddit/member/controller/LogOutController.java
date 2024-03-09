package kr.or.ddit.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login/logOut.do")
public class LogOutController {
	@PostMapping
	public String logoutProcess(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
