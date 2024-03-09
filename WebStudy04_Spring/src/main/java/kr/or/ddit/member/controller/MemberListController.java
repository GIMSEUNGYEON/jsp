package kr.or.ddit.member.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.common.paging.PaginationRenderer;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;

@Controller
@RequestMapping("/member/memberList.do")
public class MemberListController {
	
	@Inject
	private MemberService service;
	
	@GetMapping
	public String list(
			@ModelAttribute("paging") PaginationInfo paging
//			, @ModelAttribute("condition") SearchCondition simpleCondition
			, @RequestParam(name = "page", required = false, defaultValue = "1") int currentPage
			, Model model
		) {
		
		paging.setCurrentPage(currentPage);
		
		List<MemberVO> memList = service.retrieveMemberList(paging);
	
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#submitForm");
		
		String pagingHTML = renderer.renderPagination(paging);
		
		model.addAttribute("memList", memList);
		model.addAttribute("pagingHTML", pagingHTML);
		
		return "member/memberList";

		
	

	}
}
