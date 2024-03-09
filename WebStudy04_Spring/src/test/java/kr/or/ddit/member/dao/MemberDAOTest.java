package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kr.or.ddit.common.exception.CustomPersistenceException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberDAOTest {
	static MemberDAO dao;
	MemberVO inputData;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}
	@BeforeEach
	void setUp() {
		inputData = new MemberVO();
		inputData.setMemId("a001");
		inputData.setMemPass("1234");
	}

	@Test
	void testSelectMemberForAuth() {
		MemberVO saved = dao.selectMemberForAuth("a001");
		assertNotNull(saved);
	}
	
	@Test
	void testSelectMember() {
		MemberVO a001 = dao.selectMember("a001");
		log.info("{}", a001.getCartList());
		
		log.info("a001 탈퇴 여부 : {}", a001.isMemDelete());
		MemberVO d001 = dao.selectMember("d001");
		log.info("d001 탈퇴 여부 : {}", d001.isMemDelete());
	}
	
	@Test
	void TestinsertMember() {
		MemberVO newMem = new MemberVO();
		
		assertThrows(CustomPersistenceException.class, ()->{
			dao.insertMember(newMem);
		});
		
	}
	@Test
	void testUpdate() {
		MemberVO modMem = new MemberVO();
		
		modMem.setMemId("a001");
		modMem.setMemPass("asdfasdf");
		modMem.setMemAdd1("집");
		modMem.setMemAdd2("집");
		modMem.setMemName("집");
		modMem.setMemZip("집");
		modMem.setMemHp("집");
		
		
		int cnt = dao.updateMember(modMem);
		
		assertEquals(1, cnt);
	}
	
	@Test
	void selectTotalRecordTest() {
		PaginationInfo paging = new PaginationInfo();
		
		int tr = dao.selectTotalRecord(paging);
		
		log.info("전체 레코드 수 : {}", tr);
	}
	
	@Test
	void selectListTest() {
		PaginationInfo paging = new PaginationInfo();
		
		paging.setCurrentPage(2);
		
		List<MemberVO> memList = dao.selectMemberList(paging);
		memList.forEach(m->{
			log.info("조회된 회원 목록 : {}", m);
			
		});
		
		
	}

}






