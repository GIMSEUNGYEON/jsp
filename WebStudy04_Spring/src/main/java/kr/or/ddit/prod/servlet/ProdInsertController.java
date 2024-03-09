package kr.or.ddit.prod.servlet;

import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/prod/prodInsert.do")
public class ProdInsertController {

	@Inject
	private ProdService service;

	// view layer로 연결하기 위한 컨트롤러
	@GetMapping
	protected String formUI() {

		return "prod/prodForm";
	}
	
	@ModelAttribute("prod")
	public ProdVO prod() {
		return new ProdVO();
	}

	// form을 통해 전송된 데이터에 대한 처리를 위한 컨트롤러
	@PostMapping
	protected String insertProcess(
			@Validated(InsertGroup.class) @ModelAttribute("prod") ProdVO prod
			, BindingResult errors
			, Model model
			) {

		String message = null;
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.createProd(prod);
			switch (result) {
			case OK:
				return "redirect:/prod/prodView.do?what="+prod.getProdId();
			case FAIL:
				return "prod/prodForm";
			default:
				message = "상품 코드 중복";
				model.addAttribute("message", message);
				return "prod/prodForm";
			}
		} else {
			return "prod/prodForm";
		}

	}
}
