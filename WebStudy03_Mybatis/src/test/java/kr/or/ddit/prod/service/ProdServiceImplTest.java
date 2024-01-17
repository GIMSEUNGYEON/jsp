package kr.or.ddit.prod.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.ProdVO;

class ProdServiceImplTest {
	
	ProdService service = new ProdServiceImpl();
	
	@Test
	void testRetrieveList() {
		List<ProdVO> prodList = service.retrieveProdList(null);
		
		assertNotEquals(0, prodList.size());
	}

}
