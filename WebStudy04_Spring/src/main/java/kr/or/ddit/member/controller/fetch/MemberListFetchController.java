package kr.or.ddit.member.controller.fetch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/fetch")
public class MemberListFetchController{
	
   @Inject
   private MemberService service;
   
   @GetMapping("memberList.do")
   public String listUI() {
      return "member/fetch/memberList";
   }
   
   @PostMapping(value="memberList.do", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public List<MemberVO> listData(
		   @RequestBody PaginationInfo paging
		   , @RequestParam(value = "page", required = false, defaultValue = "1" ) int currentPage
	){
	   log.info("json 데이터 수신 확인 : {}", paging);
	   log.info("json 데이터 수신 확인 : {}", currentPage);
	   
	   
	   paging.setCurrentPage(currentPage);
	   
	   List<MemberVO> memList = service.retrieveMemberList(paging);
	   
	   return memList;
   }

}


















