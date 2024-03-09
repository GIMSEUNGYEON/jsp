package kr.or.ddit.emp.pos.refund.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.pos.refund.service.EmpPosRefndService;
import kr.or.ddit.global.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.global.common.paging.PaginationInfo;
import kr.or.ddit.global.common.paging.PaginationRenderer;
import kr.or.ddit.global.vo.RefndVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/pos/refund")
public class EmpPosRefundController {
	
	@Inject
	private EmpPosRefndService service;
	
	@GetMapping
	public String refundList() {
		return "emp/pos/refund/refundList";
	}
	
	@ResponseBody
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RefndVO> listData(){
			
			List<RefndVO> refndList = service.retrieveRefndList();
			log.info("refndList : {}",refndList);
			return refndList;
		
	}
	
	
	@GetMapping("{rfndNo}")
	public RefndVO refundView(
		@PathVariable String rfndNo	
		) {
		return service.retrieveRefnd(rfndNo);
	}
}
