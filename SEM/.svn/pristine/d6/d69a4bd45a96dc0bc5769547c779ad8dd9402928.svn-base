package kr.or.ddit.dummy.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.vo.CartVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DummyController {
	@RequestMapping("/index.do")
	public String index(Model model) {
		model.addAttribute("info", "동적 모델");
		return "admin:index";
	}
	
	@ModelAttribute("cart")
	public CartVO cart() {
		return new CartVO();
	}
	
	@GetMapping("/insertCart.do")
	public String dummyFormUI() {
		return "user:insertCart";
	}
	
	@PostMapping("/insertCart.do")
	public String dummyProcess(@Valid @ModelAttribute("cart") CartVO cart, BindingResult errors) {
		log.info("error : {}", errors.getErrorCount());
		if(errors.hasErrors()) {
			return "insertCart";
		}else {
			log.info("서버에 저장 완료");
			return "redirect/index.do";
		}
	}
}






















