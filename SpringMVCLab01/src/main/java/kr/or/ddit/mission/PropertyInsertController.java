package kr.or.ddit.mission;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.mission.vo.PropertyVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mission")
public class PropertyInsertController {

	@GetMapping("propView")
	public void formUI(@ModelAttribute("property") PropertyVO property) {
		
	}
	
	@PostMapping("propView")
	public String processFormData(@Valid @ModelAttribute("property") PropertyVO property, BindingResult errors, RedirectAttributes redirectAttributes) {
		if(!errors.hasErrors()) {
			log.info("command object : {}", property);
			String message = "프로퍼티 등록 성공!";
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/";
		}else {
			return "mission/propView";
		}
	}
}
