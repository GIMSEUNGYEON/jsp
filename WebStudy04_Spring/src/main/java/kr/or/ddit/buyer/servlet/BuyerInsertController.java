package kr.or.ddit.buyer.servlet;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.BuyerVO;

@Controller
@RequestMapping("/buyer/buyerInsert.do")
public class BuyerInsertController {

	@Inject
	private BuyerService service;
	
	@GetMapping
	public String fomrUI(){
		return "buyer/buyerForm";
	}
	
	@ModelAttribute("buyer")
	public BuyerVO buyer() {
		return new BuyerVO();
	}
	
	@PostMapping
	public String doPost(
				@Validated(InsertGroup.class) @ModelAttribute("buyer") BuyerVO buyer
				, BindingResult errors
			){
		
		String logicalViewName = null;
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.createBuyer(buyer);
			switch (result) {
			case OK:
				logicalViewName = "redirect:/buyer/buyerView.do?what="+buyer.getBuyerId();
				break;
			case FAIL:
				logicalViewName = "buyer/buyerForm";
				break;
			}
		}else {
			logicalViewName = "buyer/buyerForm";
		}

		return logicalViewName;
	}
}
