package kr.or.ddit.property.servlet09;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.property.service.PropertyService;
import kr.or.ddit.vo.PropertyVO;

@Controller
@RequestMapping("/12/jdbcDesc.do")
public class JdbcDescController {
	
	@Inject
	private PropertyService service;
	
	@GetMapping
	public String doGet(Model model) {
		
		List<PropertyVO> propList = service.retrieveProperties();
		model.addAttribute("propList", propList);

		return "12/jdbcDesc"; 
	}
}
