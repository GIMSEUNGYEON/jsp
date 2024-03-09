package kr.or.ddit.property.servlet09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/09/propView.do")
public class PropViewController {
	
	@GetMapping
	public String doGet() {
		return "09/propView"; 
		
	}
}
