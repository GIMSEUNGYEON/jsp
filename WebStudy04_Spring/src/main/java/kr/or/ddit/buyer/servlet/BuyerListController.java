package kr.or.ddit.buyer.servlet;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.common.paging.PaginationRenderer;
import kr.or.ddit.vo.BuyerVO;

/**
 * 스크린 사이즈는 3 블럭사이즈는 2를 기준으로 한 페이징 처리
 * 다음의 검색 상황에 대한 지원 
 *  : 전자제품 분류에 해당하는 제조사 중 서울 지역의 제조사 중 삼성전자라는 이름이 포함된 제조사 정보 검색
 * 제조사 분류(select에서 이름을 선택, 넘어가는 value는 코드), 지역, 이름
 */
@Controller
@RequestMapping("/buyer")
public class BuyerListController  {
	

	@Inject
	private BuyerService service;

	@GetMapping("buyerList.do")
	public String listUI(
		@RequestParam Map<String, Object> detailCondition
		, @RequestParam(name = "page", required = false, defaultValue = "1") int currentPage
		, Model model
	){
	
		model.addAttribute("condition", detailCondition);

		PaginationInfo paging = new PaginationInfo(3,2);

		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(detailCondition);

		List<BuyerVO> buyerList = service.retrieveBuyerList(paging);

		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		
		String pagingHTML = renderer.renderPagination(paging);
		
		model.addAttribute("buyerList", buyerList);
		model.addAttribute("pagingHTML", pagingHTML);
		
		return "buyer/buyerList";
				
	}
	
	@GetMapping("buyerView.do")
	public String formUI(
			@RequestParam("what") String buyerId
			, Model model
			) {
		BuyerVO buyer = service.retrieveBuyer(buyerId);
		model.addAttribute("buyer", buyer);
		return "buyer/buyerView";
	}
}
