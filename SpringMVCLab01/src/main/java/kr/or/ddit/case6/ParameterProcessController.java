package kr.or.ddit.case6;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.case6.vo.CommandObject;
import lombok.extern.slf4j.Slf4j;

/**
 * 더하기 연산 처리
 * url : /case6/paramterProcess
 * 모든 연산의 처리가 완료되면, 연산의 처리 결과는 (GET)핸들러를 통해 formView에서 출력함.
 * model 명 : result
 * 
 * Post 요청 핸들러 메소드는 2가지 방식으로 구현할 것.
 * 낱개의 파라미터를 별개 수신하는 방식과 command object를 활용함.
 * 
 */
@Slf4j
@Controller
@RequestMapping("/case6/paramterProcess")
public class ParameterProcessController {
	
	@GetMapping
	public String getHandler(Model model) {
		return "case6/formView";
	}
	
//	@PostMapping
	public String postHandlerParameters(
			@RequestParam(required = true) double left, 
			@RequestParam(required = true) double right, 
			RedirectAttributes redirectAttributes) {
		double result = left + right;
		redirectAttributes.addFlashAttribute("result", result);
		return "redirect:/case6/paramterProcess";
	}
	
	@PostMapping
	public String postHandlerCommandObject(@ModelAttribute("object") CommandObject object, RedirectAttributes redirectAttributes) {
		object.setResult(object.getLeft() + object.getRight());
		redirectAttributes.addFlashAttribute("object", object);		
		return "redirect:/case6/paramterProcess";
	}
}
