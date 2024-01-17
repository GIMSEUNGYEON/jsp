package kr.or.ddit.mission;

import java.time.LocalDateTime;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * url : /mission/now.nhn
 * method : GET
 * model : 현재 시각, model명 : now
 * response content type : HTML / JSON
 * 
 */
@Controller
@RequestMapping("/mission")
public class ModelAndViewMissionController {
	
	@Inject
	private NowGeneratorService service;
	
	@GetMapping("now.nhn")
	public String htmlGetMethod(Model model){
		LocalDateTime now = service.receiveNow();
		model.addAttribute("now",now);
		return "mission/resultView";
	}
	
	@GetMapping(value = "now.nhn", produces = MediaType.APPLICATION_JSON_VALUE)
	public String jsonGetMethod(Model model) {
		LocalDateTime now = service.receiveNow();
		model.addAttribute("now",now);		
		return "mission/resultView";
//		return "jsonView";
		// spring 내부에서 content negotiator 가 동작함.
		
	}
}
