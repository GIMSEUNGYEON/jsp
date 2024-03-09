package kr.or.ddit.buyer.servlet;

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

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.BuyerVO;

@Controller
@RequestMapping("/buyer/buyerUpdate.do")
public class ByerUpdateController {
	
	@Inject
	BuyerService service;
	
	@GetMapping
	public String editUI(
		@RequestParam("what") String buyeId
		, Model model
	) {
		BuyerVO buyer = service.retrieveBuyer(buyeId);
		
		model.addAttribute("buyer", buyer);
		
		return "buyer/buyerEdit";
	}
	
	@PostMapping
	public String updateProcess(
				@Validated(UpdateGroup.class) @ModelAttribute("buyer") BuyerVO buyer
				, BindingResult errors
				, Model model
				, RedirectAttributes redirectAttributes
			) {

		String logicalViewName = null;
		String message = null;
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyBuyer(buyer);
			switch (result) {
			case OK:
				logicalViewName = "redirect:/buyer/buyerView.do?what="+buyer.getBuyerId();
				redirectAttributes.addFlashAttribute("message", "수정 성공");
				break;
			default:
				logicalViewName = "buyer/buyerEdit";
				message = "서버 오류";
				break;
			}
			model.addAttribute("message", message);
		}else {
			logicalViewName = "buyer/buyerEdit";
		}
		return logicalViewName;
	}
	
	
}
