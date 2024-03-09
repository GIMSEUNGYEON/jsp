package kr.or.ddit.member.controller;

import java.security.Principal;

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
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.MemberVO;

@Controller
@RequestMapping("/member/memberUpdate.do")
public class MemberUpdateController {

	@Inject
	private MemberService service;
	
	@GetMapping
	public String updateForm(
			Principal principal
			, Model model) {
		// 현재 로그인한 사용자의 기본정보를 초기값으로 가지고 있는 수정 양식의 제공

		MemberVO member = service.retrieveMember(principal.getName());

		model.addAttribute("member", member);

		return "member/memberEdit";

	}
	
	@PostMapping
	public String updateProcess (			
			Principal principal
			, @Validated(UpdateGroup.class) @ModelAttribute("member") MemberVO member
			, BindingResult errors
			, Model model) {

		model.addAttribute("member", member);
		
		member.setMemId(principal.getName());
		
		String logicalViewName = null;
		String message = null;

		if (!errors.hasErrors()) {
			ServiceResult result = service.ModifyMember(member);
			switch (result) {
			case OK:
				logicalViewName = "redirect:/mypage";
				break;
			case FAIL:
				logicalViewName = "member/memberEdit";
				message = "서버에 일시적 오류 발생";
				break;
			default:
				logicalViewName = "member/memberEdit";
				message = "비밀번호가 일치하지 않음";
				break;
			}
			model.addAttribute("message", message);
		} else {
			logicalViewName = "member/memberEdit";
		}
		return logicalViewName;
	}
}
