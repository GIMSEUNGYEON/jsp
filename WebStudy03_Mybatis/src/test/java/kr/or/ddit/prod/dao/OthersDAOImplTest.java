package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import kr.or.ddit.others.dao.OthersDAO;
import kr.or.ddit.others.dao.OthersDAOImpl;
import lombok.extern.slf4j.Slf4j;
@Slf4j
class OthersDAOImplTest {

	OthersDAO dao = new OthersDAOImpl();
	
	@Test
	void testSelectLprodList() {
		dao.selectLprodList().forEach(p->{
			log.info("각 맵 : {}",p);
		});
	}

	@Test
	void testSelectBuyerList() {
		List<Map<String, Object>> prodList = dao.selectBuyerList();
		
		prodList.forEach(p->{
			log.info("각 맵 : {}",p);
		});
	}
}
