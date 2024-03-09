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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.ProdVO;

@Controller
@RequestMapping("/prod/prodUpdate.do")
public class ProdUpdateController {

	@Inject
	private ProdService service;

	@ModelAttribute("prod")
	public ProdVO prod() {
		return new ProdVO();
	}

	@GetMapping
	protected String doGet(@RequestParam("what") String prodId, Model model) {

		ProdVO prod = service.retrieveProd(prodId);
		
		model.addAttribute("prod", prod);
		
		return "prod/prodEdit";
	
	}
	
	@PostMapping
	protected String updateProcess(
			@Validated(UpdateGroup.class) @ModelAttribute("prod") ProdVO prod
			, BindingResult errors
			, Model model
			, RedirectAttributes redirectAttributes
			) {
		
		String logicalViewName = null;
		String message = null;
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyProd(prod);
			switch (result) {
			case OK:
				logicalViewName = "redirect:/prod/prodView.do?what="+prod.getProdId();
				redirectAttributes.addFlashAttribute("message", "수정 성공");
				break;
			case FAIL:
				logicalViewName = "prod/prodEdit";
				message = "서버 오류";
				break;
			}
			model.addAttribute("message", message);
			
		} else {
			logicalViewName = "prod/prodEdit";
		}
		
		return logicalViewName;
	}
}
