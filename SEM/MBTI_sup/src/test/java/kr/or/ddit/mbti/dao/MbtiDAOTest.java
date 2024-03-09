package kr.or.ddit.mbti.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.MbtiDescVO;

class MbtiDAOTest {
	MbtiDAO dao = new MbtiDAOImpl();
	
	@Test
	void testSelectMbtiList() {
		assertDoesNotThrow(()->{
			dao.selectMbtiList();
		});
		
		List<MbtiDescVO> list = dao.selectMbtiList();
		
		assertNotNull(list);
		assertEquals(14, list.size());
	}

	@Test
	void testSelectMbti() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testInsertMbti() {
		MbtiDescVO newMbti = new MbtiDescVO();
		newMbti.setMtType("esfj");
		newMbti.setMtTitle("ESFJ 친선도모형");
		newMbti.setMtContent("생각보다 철저함.\r\n"
				+ "--        혼자 계획 세우고 그 계획 틀어지는 거 싫어함.\r\n"
				+ "--        술자리 좋아함.\r\n"
				+ "--        남 눈치 많이 봄.\r\n"
				+ "--        책 읽고 영화보는거 좋아함.\r\n"
				+ "--        상담, 고민 들어주는 거 잘함.\r\n"
				+ "--        친구, 가족 내 주변 인물들 다 챙김.\r\n"
				+ "--        인간관계에서 상처받아도 그 사람 배려한다고 얘기 못함.\r\n"
				+ "--        어디 나가면 어색한거 못참고 먼저 말 검.");
		assertEquals(1, dao.insertMbti(newMbti));
	}

}














