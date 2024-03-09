package kr.or.ddit.dummy.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ddit.dummy.service.DummyService;
import kr.or.ddit.security.MemberVOWrapper;
import kr.or.ddit.security.RealUser;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DummyController {
	
	@Inject
	private DummyService service;
	
	@GetMapping("/dummy")
	public String dummy(
		Principal authentication
		, Authentication authentication2
		, @AuthenticationPrincipal MemberVOWrapper principal
		, @AuthenticationPrincipal(expression = "realUser") MemberVO realUser
		, @RealUser MemberVO realUser2
	) {
		log.info("case 1 principal : {}", authentication);
		log.info("case 2 authentication : {}", authentication2);
		log.info("case 3 MemberVOWrapper : {}", principal);
		log.info("case 4 MemberVO : {}", realUser);
		log.info("case 5 MemberVO : {}", realUser2);
		
		service.dummyLogic();
		
		return "index";
	}
}
