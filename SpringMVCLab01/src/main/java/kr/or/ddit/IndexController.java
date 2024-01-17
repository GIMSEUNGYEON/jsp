package kr.or.ddit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	@RequestMapping("/index.do")
	public String indexHandler() {
		return "index";
	}
}
