package kr.or.ddit.member.controller;

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
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.MemberVO;

/**
 * 회원 가입 처리 
 * 1. 가입 양식 제공(get) 
 * 2. 양식을 통해 입력 및 전송된 데이터 처리(post)
 * 
 */
@Controller
@RequestMapping("/member/memberInsert.do")
public class MemberInsertController {

	@Inject
	private MemberService service;

	@GetMapping
	protected String formUI(){

		return "member/memberForm";
	}
	
	@ModelAttribute("member")
	public MemberVO member() {
		return new MemberVO();
	}
	
	@PostMapping
	protected String insertProcess(
			@Validated(InsertGroup.class) @ModelAttribute("member") MemberVO member
			, BindingResult errors
			, Model model
		) {
		/*
		 * 1. 특수문자 디코딩 설정 
		 * 2. 17개의 파라미터를 받고 -> Command Object로 캡슐화(MemberVO) 
		 * 2-1. 검증 작업 :통과, 불통 
		 * 3. 가입 로직 호출 
		 * 4. 로직의 실행결과에 따라 view 선택 
		 * 5. 해당 뷰로 이동
		 */
		model.addAttribute("member", member);

		String logicalViewName = null;
		String message = null;

		if (!errors.hasErrors()) {
			ServiceResult result = service.createMember(member);
			switch (result) {
			case OK:
				logicalViewName = "redirect:/"; // PostRedirectGet Pattern
				break;

			case FAIL:
				logicalViewName = "member/memberForm";
				break;

			default: // 아이디 중복
				logicalViewName = "member/memberForm";
				message = "아이디 중복입니다.";
				break;
			}

			model.addAttribute("message", message);

		} else {
			logicalViewName = "member/memberForm";
		}
		return logicalViewName;
	}
}
