package kr.or.ddit.member.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
class MemberServiceImplTest {

	MemberService service = new MemberServiceImpl();
	
	@Test
	void testModify() {
		MemberVO member = new MemberVO();
		member.setMemId("c001");
		member.setMemPass("7777");
		member.setMemAdd1("집");
		member.setMemAdd2("집");
		member.setMemName("집");
		member.setMemZip("집");
		member.setMemHp("집");
		
		ServiceResult result = service.ModifyMember(member);
		
		assertEquals(ServiceResult.OK, result);
	}
	
	@Test
	void testModify2() {
		MemberVO member = new MemberVO();
		member.setMemId("c001");
		member.setMemPass("7777");
	
		ServiceResult result = service.ModifyMember(member);
		
		assertEquals(ServiceResult.OK, result);
	}
	
	@Test
	void retrieveMemberListTest() {
		PaginationInfo paging = new PaginationInfo(3,3);
		
		paging.setCurrentPage(2);
		
		List<MemberVO> memList =  service.retrieveMemberList(paging);
		
		memList.forEach(m->{
			log.info("조회된 회원 목록 : {}", m);			
		});
		
	}

}
